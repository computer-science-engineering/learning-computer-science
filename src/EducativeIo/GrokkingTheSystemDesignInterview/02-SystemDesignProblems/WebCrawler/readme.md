# Designing a Web Crawler

- [Designing a Web Crawler](#Designing-a-Web-Crawler)
  - [What is a Web Crawler](#What-is-a-Web-Crawler)
  - [Requirements and Goals of the System](#Requirements-and-Goals-of-the-System)
  - [Some Design Considerations](#Some-Design-Considerations)
  - [Capacity Estimation and Constraints](#Capacity-Estimation-and-Constraints)
  - [High Level design](#High-Level-design)
    - [Basic Algorithm](#Basic-Algorithm)
    - [How to crawl](#How-to-crawl)
    - [Difficulties in implementing efficient web crawler](#Difficulties-in-implementing-efficient-web-crawler)
    - [Components](#Components)
  - [Detailed Component Design](#Detailed-Component-Design)
    - [URL frontier](#URL-frontier)
    - [Fetcher module](#Fetcher-module)
    - [Document input stream](#Document-input-stream)
    - [Document dedupe test](#Document-dedupe-test)
    - [URL filters](#URL-filters)
    - [Domain name resolution](#Domain-name-resolution)
    - [URL dedupe test](#URL-dedupe-test)
    - [Checkpointing](#Checkpointing)
  - [Fault tolerance](#Fault-tolerance)
  - [Data Partitioning](#Data-Partitioning)
  - [Crawler Traps](#Crawler-Traps)

Design a Web Crawler that will systematically browse and download the World Wide Web. Web crawlers are also known as web spiders, robots, worms, walkers, and bots.

## What is a Web Crawler

## Requirements and Goals of the System

**Scalability:** Our service needs to be scalable such that it can crawl the entire Web and can be used to fetch hundreds of millions of Web documents.

**Extensibility:** Our service should be designed in a modular way with the expectation that new functionality will be added to it. There could be newer document types that needs to be downloaded and processed in the future.

## Some Design Considerations

- Is it a crawler for HTML pages only? Or should we fetch and store other types of media, such as sound files, images, videos, etc.?
  - If we are writing a general-purpose crawler to download different media types, we might want to break down the parsing module into different sets of modules: one each for HTML, images, videos, etc., where each module extracts what is relevant for its corresponding media type.
  - We assume crawler will handle only HTML, but should be extensible.
- What protocols are we looking at? HTTP? What about FTP links? What different protocols should our crawler handle?
  - We assume HTML, but should be extensible.
- What is the expected number of pages we will crawl? How big will the URL database become?
  - We assume we need to crawl 1 B websites.
  - Since a website can contain any number of URLs, we assume an upper bound of 15 B web pages.
- RobotsExclusion
  - We will honor all exclusions as defined in robot.txt.

## Capacity Estimation and Constraints

- Say, we need to crawl 15 B pages in 4 weeks.
- Pages needed to fetch per second: `15 B / (4 weeks * 7 days * 86400 sec) ~= 6200 pages/sec`.
- Storage
  - Say, average page size = 100 KB.
  - Say, each page will include 500 bytes of metadata.
  - Total storage needed: `15 B * (100 KB + 500) ~= 1.5 PB`.
  - Assuming 70% capacity model, total storage needed: `1.5 PB / 0.7 ~= 2.14 PB`.

## High Level design

### Basic Algorithm

Take a list of seed URLs as input and repeatedly execute following steps:

1. Pick a URL from the unvisited URL list.
2. Determine the IP Address of its host-name.
3. Establish a connection to the host to download the corresponding document.
4. Parse the document contents to look for new URLs.
5. Add the new URLs to the list of unvisited URLs.
6. Process the downloaded document, e.g., store it or index its contents, etc.
7. Go back to step 1.

### How to crawl

- Breadth first (BFS) or depth first (DFS)
  - BFS is usually used.
  - DFS is used in situations such as where crawler has already established a connection with the website.
- Path-ascending crawling
  - Path-ascending crawling can help discover a lot of isolated resources or resources for which no inbound link would have been found in regular crawling of a particular Web site.
  - In this scheme, a crawler would ascend to every path in each URL that it intends to crawl.
  - For example, when given a seed URL of `http://foo.com/a/b/page.html`, it will attempt to crawl /a/b/, /a/, and /.

### Difficulties in implementing efficient web crawler

- Large volume of Web pages.
- Rate of change on web pages.

### Components

1. **URL frontier:** To store the list of URLs to download and also prioritize which URLs should be crawled first.
2. **HTML Fetcher:** To retrieve a web page from the server.
3. **Extractor:** To extract links from HTML documents.
4. **Duplicate Eliminator:** To make sure the same content is not extracted twice unintentionally.
5. **Datastore:** To store retrieved pages, URLs, and other metadata.

![high level design](https://raw.githubusercontent.com/tuliren/grokking-system-design/master/img/web-crawler-overview.png)

## Detailed Component Design

- Crawler will run on one server and all crawling will be done by multiple worker threads.
- Each worker thread will perform all steps needed to download and process a document in a loop.
- Workflow
  - Remove an absolute URL from the shared URL frontier for downloading.
  - Based on the URL's scheme, the worker calls the appropriate protocol module to download the document.
  - After downloading, the document is placed into a Document Input Stream (DIS).
  - Putting documents into DIS will enable other modules to re-read the document.
  - Then the worker thread invokes the dedupe test to determine if the document (perhaps associated with a different URL) has been seen before.
    - If so, the document is not processed any further and the worker thread removes the next URL from the frontier.
  - Next, the crawler needs to process the downloaded document.
  - Based on the downloaded document's MIME type, the worker invokes the process method of each processing module associated with that MIME type.
  - The HTML processing module will extract all links from the page.
    - Each link is converted to an absolute URL and tested against a user-supplied URL filter to determine if it should be downloaded.
    - If the URL passes the filter, the worker checks if it has been seen before, i.e., if it is in the URL frontier, or has already been downloaded.
    - If URL is new, it is added to the frontier.

![detailed component design](https://raw.githubusercontent.com/tuliren/grokking-system-design/master/img/web-crawler-detail.png)

### URL frontier

- Data structure that contains all the URLs that remain to be downloaded.
- Perform crawl by a BFS traversal, starting from pages in seed set.
  - Easily implemented using a FIFO queue.
- Since list of URLs to crawl is large, URL frontier can be distributed into multiple servers.
- On each server we will have multiple worker threads performing crawling tasks.
- A hash function will map each URL to a server which will be responsible for crawling it.
- Politeness requirements:
  - Crawler should not overload a web server by downloading too many pages.
  - Multiple machines should not connect to a web server.
- Politeness requirements implementation:
  - Collection of distinct FIFO sub-queues on each server.
  - Dedicated sub-queue for each worker thread, from where it removes URLs for crawling.
  - When a new URL needs to be added, the FIFO sub-queue where it is placed will be determined by the URL's canonical hostname.
  - Hash function can map each hostname to a worker thread number.
  - Together above two points will ensure that at most one worker thread will download documents from a web server, and also by using FIFO queue, it will not overload a web server.
- **Size of URL frontier**
  - Millions of URLs.
  - URLs will be stored on disk.
  - Separate buffers for enqueuing and dequeuing.
  - Enqueue buffer, when full, will be dumped to disk.
  - Dequeue buffer will keep a cache of URLs that need to be visited, it will periodically read from disk to fill the buffer.

### Fetcher module

- Download the document corresponding to a given URL using the appropriate network protocol like HTTP.
- To avoid downloading robots.txt on every request, our crawler's HTTP protocol module can maintain a fixed-sized cache, mapping host-names to their robot's exclusion rules.

### Document input stream

- Same document can be processed by multiple processing modules.
- To avoid downloading a document multiple times, we cache the document locally using an abstraction called a Document Input Stream (DIS).
- DIS is an input stream that caches the entire contents of the document read from the internet.
- Provides methods to re-read the document.
- Small documents (<= 64 KB) are cached in memory, while large documents are temporarily written to a backing file.
- Each worker thread has an associated DIS, which it reuses from document to document.
- After extracting a URL from the URL frontier, the worker then passes that URL to the relevant protocol module, which initializes the DIS from a network connection to contain the document's contents.
- The worker then passes the DIS to all relevant processing modules.

### Document dedupe test

- Handles situation where
  - documents are available under multiple different URLs.
  - documents are mirrors in different servers.
- To prevent processing a document more than once, a dedupe test is performed on each document.
- 64-bit checksum (MD5 or SHA) is calculated of every processed document and then stored in a d/b.
- For every new document, we compare its checksum to all previously calculated checksums.
- **Size of checksum store**
  - Unique set containing checksums of all previously processed documents.
  - `15 B documents * 8 bytes (size of single checksum) = 120 GB`
  - Single server, or LRU cache with backing persisted storage.

### URL filters

- Way to control the set of URLs downloaded.
- Can be used to blacklist websites so crawler can ignore them.
- Before adding each URL to the frontier, the worker thread consults the user-supplied URL filter.
- Filters can be defined to restrict URLs by domain, prefix, or protocol type.

### Domain name resolution

- Before contacting a web server, a web crawler must using the DNS to map the web server's hostname to an IP address.
- To avoid repeated requests and other performance issues due to large number of URLs, DNS results should be cached by building local DNS server.

### URL dedupe test

- While extracting links, web crawler will encounter multiple links to the same document.
- To avoid downloading and processing the same document, a URL dedupe tests will be performed on each extracted link before adding it to the URL frontier.
- Mechanism
  - Store all the URLs seen by crawler in canonical form in a d/b.
  - We store only the fixed-size checksum and not the actual textual URL, to save space.
  - We can keep an in-memory cache of popular URLs on each host, shared by all worker threads.
- **Storage needed:**
  - Unique set containing checksums of all previously seen URLs.
  - `15 B documents * 4 bytes (size of single checksum) = 60 GB`
- **Bloom filters for deduping?**
  - Bloom filters are a probabilistic data structure for set membership testing that may yield false positives.

### Checkpointing

- Given that crawling 15 B web pages can take a long time, to guard against runtime failures, crawler should write snapshots of its state to disk.
- Interrupted or aborted crawl can be restarted from latest checkpoint.

## Fault tolerance

- Consistent hashing for distribution among crawling servers.
  - Will help in replacing a dead host.
  - Will help in distributing load among crawling servers.
- All crawling servers will be performing regular checkpointing and storing their FIFO queues to disks.
- If a server goes down, we can replace it.
- Consistent hashing should shift the load to other servers.

## Data Partitioning

Crawler deals with 3 types of data:

- URLs to visit.
- URL checksums for dedupe.
- Document checksums for dedupe.

Since URL maps to hostname, all above data for a URL can be stored on the same host. Consistent hashing will handle redistribution from overloaded hosts. Checkpoint of data will happen, so if a server dies another server can replace it by taking data from last snapshot.

## Crawler Traps

- A crawler trap is a URL or set of URLs that cause a crawler to crawl indefinitely.
- May be unintentional, such as using symbolic links.
- Intentional traps include scripts that dynamically generate infinite loop of documents.
- Anti-spam traps are designed to catch crawlers used by spammers looking for email addresses, while other sites use traps to catch search engine crawlers to boost their search ratings.
