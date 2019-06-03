# Designing a Web Crawler

- [Designing a Web Crawler](#designing-a-web-crawler)
  - [What is a Web Crawler](#what-is-a-web-crawler)
  - [Requirements and Goals of the System](#requirements-and-goals-of-the-system)
  - [Some Design Considerations](#some-design-considerations)
  - [Capacity Estimation and Constraints](#capacity-estimation-and-constraints)
  - [High Level design](#high-level-design)
    - [Basic Algorithm](#basic-algorithm)
    - [How to crawl](#how-to-crawl)
    - [Difficulties in implementing efficient web crawler](#difficulties-in-implementing-efficient-web-crawler)
    - [Components](#components)
  - [Detailed Component Design](#detailed-component-design)
  - [Fault tolerance](#fault-tolerance)
  - [Data Partitioning](#data-partitioning)
  - [Crawler Traps](#crawler-traps)

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
  - We will honor an exclusions as defined in robot.txt.

## Capacity Estimation and Constraints

- Say, we need to crawl 15 B pages in 4 weeks
- Pages needed to fetch per second: `15 B / (4 weeks * 7 days * 86400 sec) ~= 6200 pages/sec`
- Storage
  
    ```text
    Say, average page size = 100 KB.
    Say, each page will include 500 bytes of metadata 
    Total storage needed
        = 15 B * (100 KB + 500) ~= 1.5 PB
    Assuming 70% capacity model, total storage needed
        = 1.5 PB / 0.7 ~= 2.14 PB
    ```

## High Level design

### Basic Algorithm

Take a list of seed URLs as input and repeatedly execute following steps:

1. Pick a URL from the unvisited URL list.
2. Determine the IP Address of its host-name.
3. Establish a connection to the host to download the corresponding document.
4. Parse the document contents to look for new URLs.
5. Add the new URLs to the list of unvisited URLs.
6. Process the downloaded document, e.g., store it or index its contents, etc.
7. Go back to step 1

### How to crawl

- Breadth first (BFS) or depth first (DFS)
  - BFS is usually used.
  - DFS is used in situations such as where crawler has already established a connection with the website.
- Path-ascending crawling
  - Path-ascending crawling can help discover a lot of isolated resources or resources for which no inbound link would have been found in regular crawling of a particular Web site.
  - In this scheme, a crawler would ascend to every path in each URL that it intends to crawl.
  - For example, when given a seed URL of http://foo.com/a/b/page.html, it will attempt to crawl /a/b/, /a/, and /.

### Difficulties in implementing efficient web crawler

- Large volume of Web pages
- Rate of change on web pages

### Components

1. URL frontier: To store the list of URLs to download and also prioritize which URLs should be crawled first.
2. HTML Fetcher: To retrieve a web page from the server.
3. Extractor: To extract links from HTML documents.
4. Duplicate Eliminator: To make sure the same content is not extracted twice unintentionally.
5. Datastore: To store retrieved pages, URLs, and other metadata.

![high level design](https://raw.githubusercontent.com/tuliren/grokking-system-design/master/img/web-crawler-overview.png)

## Detailed Component Design

## Fault tolerance

## Data Partitioning

## Crawler Traps
