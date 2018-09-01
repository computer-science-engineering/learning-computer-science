# Problem Definition

## Description

Web crawlers are among the most commonly used systems to aggregate large amounts of information. For instance, search engines like Google use crawlers to collect information from websites; similarly, news websites use crawlers to aggregate data sources.

How would you design a modern web crawler?

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

1. Requirements

    - Is fed URL(s)
    - Parse data - list of articles
    - AuthorName, Number of articles per author

1. Modules

    - Walk through all pages (via links in initial page and so forth).
    - Store AuthorName for each article (along with article name) [Use correct DS]
    - Store URLs
    - Mechanism to fetch all child pages.

    - Parsing
      - Link/URL extraction mechanism
      - AuthorName extraction
      - Article name extraction
      - Duplication elimination mechanism

    - Storage
      - Data store (BE) (SQL)
      - DS (for in-memory storage, caching, etc.) [Optional] 
      - Data Model
        - Index; URL; AuthorName

1. High-level view

    - Gateway micro-service (not needed within the context of this question)
    - Accepts requests (parse entry-point page)
    - Load-balancing logic
    - Calls page parser MS.

    - Some message-broker to send links (child URLs to parse).
      - MB processor micro-service (subscribes to the MB).
        - Parse that page

    - Page parser micro-service.
    - Use some open-source 3rd party web-page parser.
    - Takes in a html page
    - Check with BE Data Store is already parsed.
    - Parses to obtain
        - Links
          - BL in some module - sends links to MB.
        - AuthorName
        - ArticleName
        - Send data model to BE SQL d/b.

## Notes

1. [Pramp - The Complete System Design Interviewer Guide](https://medium.com/@pramp/the-complete-system-design-interviewer-guide-e5d273724db8)
1. [GitHub - Donne Martin system-design-prime](https://github.com/donnemartin/system-design-primer/tree/master/solutions/system_design/web_crawler#design-a-web-crawler)