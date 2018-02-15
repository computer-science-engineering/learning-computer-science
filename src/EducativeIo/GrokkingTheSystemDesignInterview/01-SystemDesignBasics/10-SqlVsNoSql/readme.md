# SQL vs. NoSQL

* SQL - relational database. NoSql - non-relational database.
* Relational databases
  * structures
  * predefined schemas
* Non-relational databases
  * unstructured
  * distributed
  * dynamic schema

## SQL

* Relational databases store data in rows and columns.
* each row contains all information about one entity.
* Columns are separate data points.
* Eg.: MySQL, Oracle, MS SQL Server, SQLite, Postgres, MariaDB, etc.

## NoSQL

Most common types of NoSQL:

### Key-Value Stores

* Data stored in array of key-value pairs.
* Key is an attributed name, which is linked to a value.
* Eg.: Redis, Voldemort, Dynamo.

### Document Databases

* Data is stored in documents instead of rows and columns in a table.
* Documents are grouped together in collections.
* Each document can have an entirely different structure.
* Eg.: CouchDB, MongoDB.

### Wide-Column Databases

* Instead of tables, there are column families which are containers for rows.
* No need to know all columns ahead of time.
* Each row does not need to have same number of columns.
* Suitable for analyzing large datasets.
* Eg.: Cassandra, HBase.

### Graph Databases

* For storing data whose relations are best represented in a graph.
* Data saved in graph structures with
  * nodes (entities)
  * properties (information about entities)
  * lines (connections between the entities)
* Eg.: Neo4J, InfiniteGraph.

## High level differences between SQL and NoSQL

### Storage

* SQL databases have tabular storage model where each row represents an entity, and each column represents a data point about that entity.
* NoSQL databases have different storage models - key-value, document, graph, columnar.

### Schema

* SQL databses have fixed schema. Changing schema entails modification of whole database and taking it offline.
* NoSQL databases have dynamic schema.

### Querying

* SQL databases have structured querying language.
* In NoSQL databases, queries are focused on a collection of documents, sometimes called UnQL (Unstructured Query Language). Different databases have different syntax for using UnQL.

### Scalability

* SQL databases are vertically scalable - increasing the horsepower (higher Memory, CPU, etc.) of the hardware. This is expensive.
* NoSQL databases are horizontally scalable - addition of more servers. Many NoSQL stacks distribute data across servers automatically.

### Reliability or ACID Compliancy (Atomicity, Consistency, Isolation, Durability)

* Most SQL databases are ACID compliant.
* Most NoSQL solutions sacrifice ACID compliance for performance and scalability.

## SQL VS. NoSQL - Which one to use

### Reasons to use SQL database

* Ensuring ACID compliance. ACID compliance
  * reduces anomalies
  * protects integrity of the database by prescribing exactly how transactions interact with it.
* Data is strctured and static.

### Reasons to use NoSQL database

* Large volumes of data with little to no structure.
* Utilization of cloud computing and storage.
* Rapid development.