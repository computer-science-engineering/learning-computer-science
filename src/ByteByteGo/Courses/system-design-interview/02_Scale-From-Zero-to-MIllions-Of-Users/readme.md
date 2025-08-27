# Scale From Zero To Millions Of Users

1. [Single server setup](#single-server-setup)
2. [Database](#database)
3. [Which databases to use?](#which-databases-to-use)
4. [Vertical scaling vs horizontal scaling](#vertical-scaling-vs-horizontal-scaling)

## Single server setup

```plantuml
package "User" {
  [Mobile app]
  [Web browser]
}
frame "DNS" {
}
DNS --> User : IP address
User --> DNS : api.mysite.com
node "Web server" {
}
User --> "Web server" : www.mysite.com
User --> "Web server" : api.mysite.com
```

```plantuml
package "User" {
  [Mobile app]
  [Web browser]
}
frame "DNS" {
}
DNS --> User : (2) 15.125.23.214
User --> DNS : (!) api.mysite.com
node "Web server" {
}
User --> "Web server" : (3) 15.125.23.214
User --> "Web server" : (4) HTML page and/or JSON response
```

Example of API response in JSON:

`GET /users/12 – Retrieve user object for id = 12`

```json
{
   "id":12,
   "firstName":"John",
   "lastName":"Smith",
   "address":{
      "streetAddress":"21 2nd Street",
      "city":"New York",
      "state":"NY",
      "postalCode":10021
   },
   "phoneNumbers":[
      "212 555-1234",
      "646 555-4567"
   ]
}
```

## Database

With growth, multiple servers are needed. Distinct for web/mobile traffic and database, which also allows for independent scaling.

```plantuml
package "User" {
  [Mobile app]
  [Web browser]
}
frame "DNS" {
}
DNS --> User : IP address
User --> DNS : api.mysite.com
node "Servers" {
  [Web server]
  [Database server]
}
User --> "Web server" : www.mysite.com
User --> "Web server" : api.mysite.com
database "Database" {
}
"Database server" --> Database : read/write/update
Database --> "Database server" : return data
```

## Which databases to use?

- Traditional relation
  - RDBMS / SQL: MySQL, Oracle database, PostgreSQL, etc.
  - Represent and store data in tables and rows.
  - Join operations across different database tables can be performed using SQL.
- Non-relational
  - NoSQL: CouchDB, Neo4j, Cassandra, HBase, Amazon DynamoDB, etc.
  - Types
    - key-value stores
    - graph stores
    - column stores
    - document stores
  - Join operations are generally not supported.
  - User-cases:
    - Super-low latency.
    - Data is unstructured, or no relational data.
    - Need to serialize and deserialize data (JSON, XML, YAML, etc.).
    - Need to store a massive amount of data.

## Vertical scaling vs horizontal scaling