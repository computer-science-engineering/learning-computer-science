# Designing Twitter Search

- [Designing Twitter Search](#designing-twitter-search)
  - [What is Twitter Search](#what-is-twitter-search)
  - [Requirements and Goals of the System](#requirements-and-goals-of-the-system)
  - [Capacity Estimation and Constraints](#capacity-estimation-and-constraints)
    - [Storage Capacity](#storage-capacity)
  - [System APIs](#system-apis)
  - [High Level Design](#high-level-design)
  - [Detailed Component Design](#detailed-component-design)
    - [Storage](#storage)
    - [Index](#index)
    - [Detailed component design diagram](#detailed-component-design-diagram)
  - [Fault Tolerance](#fault-tolerance)
  - [Cache](#cache)
  - [Load Balancing](#load-balancing)
  - [Ranking](#ranking)

Twitter is one of the largest social networking service where users can share photos, news, and text-based messages. Design a service that can store and search user tweets.

Similar Problems: Tweet search.

## What is Twitter Search

## Requirements and Goals of the System

- Let’s assume Twitter has 1.5 billion total users with 800 million DAU.
- On average Twitter gets 400 million tweets every day.
- The average size of a tweet is 300 bytes.
- Let’s assume there will be 500 M searches every day.
- The search query will consist of multiple words combined with AND/OR.
- We need to design a system that can efficiently store and query tweets.

## Capacity Estimation and Constraints

### Storage Capacity

```text
New tweets every day = 400 M
Each tweet is of size = 300 bytes
Total storage needed = 400 M * 300
  => 120 GB/day
Total storage needed per second
    = 120 GB / (24 hours * 60 mins * 60 secs)
    ~= 1.38 MB/sec
```

## System APIs

```text
search(api_dev_key, search_terms, maximum_results_to_return,
  sort, page_token)

Returns: (JSON)
A JSON containing information about a list of tweets matching the search query. Each result entry can have the user ID & name, tweet text, tweet ID, creation time, number of likes, etc.
```

## High Level Design

- Need to store all the statuses in a database.
- Need to build an index that can keep track of which word appears in which tweet.

![high level design](https://raw.githubusercontent.com/tuliren/grokking-system-design/master/img/twitter-search-overview.png)

## Detailed Component Design

### Storage

- Need to store 120 GB of new data every day.
- Storage needed for 5 years: `120 GB * 365 days * 5 years ~= 200 TB`.
- Assuming full capacity at 80%, storage needed = 250 TB.
- If we want to keep extra copy of each tweet, storage needed = 500 TB.
- Given one server can store approx 4 TB, total servers needed = 125.
- Tweets can be stored in a MySQL d/b.
  - Table with two columns
    - TweetID
    - TweetText
- Data can be partitioned based on TweetID.
- Using unique TweetID, hash function can be used to map TweetID to storage server.
- **Creating system-wide unique TweetIDs**
  - Tweets per day = 400 M
  - Tweets in 5 years = `400 M * 365 days * 5 years = 730 B`.
  - This needs 30 bits or, 5 bytes numbers to uniquely identify TweetIDs.
  - For more details on TweetID generation, refer to "Designing Twitter" problem.

### Index

- If we want to build an index for all the English words and some famous nouns like people names, city names, etc., and if we assume that we have around 300K English words and 200K nouns, then we will have 500k total words in our index.
- Say, average length of a word is 5 characters.
- Total memory needed = 500 K words * 5 = 2.5 MB (to keep index in memory)
- Say we want to keep index in memory only for tweets from last 2 years.
- Given 730 B tweets in 5 years, this will give us 292 B tweets in two years.
- Given each TweetID is 5 bytes, memory needed to store all TweetIDs: 292 B * 5 = 1460 GB.
- So, index will be  a distributed hash table, where
  - key would be the word
  - value will be a list of TweetIDs of all tweets that contain that word.
- Say each tweets has 40 words, and ignoring prepositions, around 15 words that need to be indexed.
- This implies, each TweetID will be stored 15 times in the index.
- Memory needed = (1460 * 15) + 2.5 MB ~= 21 TB.
- Given a high end server has around 144 GB memory, number of servers needed = 152.
- **Sharding**
  - **Sharding based on words**
    - Iterate through all words in a tweet and calculate hash to find which server it will be indexed.
    - To find all tweets containing a specific word we have to query only the server which contains this word.
    - Issues:
      - Can lead to hotspots, if a word becomes hot.
      - Uniform distribution of words across servers is difficult, if over time, some words can end up storing a lot of TweetIDs compared to others.
    - Solution
      - Repartition data.
      - Use consistent hashing.
  - **Sharding based on tweet object**
    - While storing, hash function will use TweetID to
      - find server and
      - index all the words of the tweet on that server.
    - While querying for a specific word,
      - we will have to query all the servers and each server will return a set of TweetIDs.
      - A centralized server will aggregate these results to return them to the user.

### Detailed component design diagram

![detailed component design](https://raw.githubusercontent.com/tuliren/grokking-system-design/master/img/twitter-search-detail.png)

## Fault Tolerance

- Secondary replica of each index server to take over if primary replica dies.
- Both primary and secondary servers will have same copy of the index.
- If both primary and secondary servers die at the same time?
  - Have to allocate new server and rebuild same index on it.
    - How to rebuild index?
      - Approach 1
        - If we were using 'Sharding based on the tweet object', the brute-force solution would be to iterate through the whole database and filter TweetIDs using our hash function to figure out all the required tweets that would be stored on this server.
          - Highly inefficient.
          - Also during time server was being rebuilt, it would not be able to server an query, thus missing some tweets that should have been seen by the user.
      - Approach 2
        - Build a reverse index that will map all the TweetID to their index server.
        - Index-Builder server can hold this information.
        - Need to build a Hashtable where
          - key will be the index server number.
          - value will be a HashSet containing all the TweetIDs being kept at that index server.
          - Because TweetIDs are in a HashSet; this will enable us to add/remove tweets from our index quickly.
          - We should also have a replica of the Index-Builder server for fault tolerance.

## Cache

- Cache in front of our database.
- Can use Memcached.
- Based on clients’ usage patterns, we can adjust how many cache servers we need.
- Cache eviction policy: LRU

## Load Balancing

- Between Clients and Application servers.
- Between Application servers and Backend server.
- Mechanism
  - Approach 1
    - Initially, a simple Round Robin approach can be adopted.
    - Simple to implement and does not introduce any overhead.
    - Will take dead servers out of the rotation and will stop sending any traffic to it.
    - Issues:
      - It won't take server load into consideration. If a server is overloaded or slow, the LB will not stop sending new requests to that server.
    - Solution
      - More intelligent LB solution can be placed that periodically queries the backend server about their load and accordingly adjusts traffic.

## Ranking

- Ranking algorithm can calculate a 'popularity number' (based on the number of likes etc.) and store it with the index.
- Each partition can sort the results based on this popularity number before returning results to the aggregator server.
- The aggregator server combines all these results, sorts them based on the popularity number, and sends the top results to the user.
