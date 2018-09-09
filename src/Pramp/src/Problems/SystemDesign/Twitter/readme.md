# Problem Definition

## Description

Twitter is an online news and social networking service, on which users post and interact with limited-size messages, known as “tweets”.

Design the Twitter timeline and search.

#####################

This editor is synced in real time with your peer.

Use it to share thoughts and resources, such as:

- Features scope
- API design
- Pseudo code for specific components
- Data model/schema
- Back-of-the-envelope calculations
- Reference links
- Link to whiteboard or diagram such as https://sketchboard.me/new

Good luck!

#####################

1. Scope
    1. Timeline and Search only.
    1. Self timeline - should see tweets from those he/she is following.
    1. User timeline - should see tweets from those he/she is following.
    1. Search.
  
1. Components
    1. Client
    1. Web servers - host API EP
    1. LB before web servers.
    1. BE storage
        1. SQL for relational entity data
        1. NoSQL for media
    1. Data Model for relational data
    1. Application servers
    1. Caching layer - between app servers and BE storage (implements LRU)
    1. LB before application servers

1. Back of the envelope calculations
    1. 1 Billion users, 100 million daily users, 100 million new tweets per day, each user follows average 100 people.
    1. Each user visits own timeline on average 2 per day, and others 5 per day. Each user sees 20 tweets per page.
    1. Total favorites per day = 100 M * 5 = 500 M favorites.
    1. Total tweets = 100 M * ((2+5) * 20) = 14 Billion per day.
    1. Each tweet is 140 characters.
    1. Total storage = 100 M * ((140 * 2) + 30) = 30 GB/day.
    1. Media: every fifth tweet has a picture and every 10th has a video (on average). Each pic is 200 KB and each video is 2 MB. (100M/5 * 200 KB) + (100M/10 * 2 MB) = 10 TB /day (assumed)
    1. Throughput: 
        1. Ingress: 15 TB/day => 100 MB/s
        1. Egress: Tweets + pics + video => 5 GB/s
    1. Search: 2000 search RPS.

1. Web servers
    1. Hosts EP
    1. Talks to application servers

1. Application servers
    1. Talks to BE storage
    1. Microservices:
        1. Read; Write - talks to Event driver; Search.
        1. Event driver service - talks to caching service, Talks to notification service, Talks to search service.
        1. Timeline generation service - talks to caching service.
        1. Search service.
        1. Notification service.

1. BE storage
    1. Metadata goes into SQL - relational data.
    1. Everything else into NoSQL.
  
S1 -> S2 -> S3 -> S4 (hashing to partitioned storage) -> BE storage
  
## Notes

1. [Pramp - The Complete System Design Interviewer Guide](https://medium.com/@pramp/the-complete-system-design-interviewer-guide-e5d273724db8)
1. [GitHub - Donne Martin system-design-primer](https://github.com/donnemartin/system-design-primer/tree/master/solutions/system_design/twitter)