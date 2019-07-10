# Section 1: Learn all the buzzwords! And install the HortonWorks Data Platform Sandbox

- [Section 1: Learn all the buzzwords! And install the HortonWorks Data Platform Sandbox](#Section-1-Learn-all-the-buzzwords-And-install-the-HortonWorks-Data-Platform-Sandbox)
  - [2. Tips for Using This Course](#2-Tips-for-Using-This-Course)
  - [4. Installing Hadoop](#4-Installing-Hadoop)
  - [5. Overview of the Hadoop Ecosystem](#5-Overview-of-the-Hadoop-Ecosystem)
    - [Hadoop Core Stack](#Hadoop-Core-Stack)
      - [HDFS](#HDFS)
      - [YARN](#YARN)
      - [MapReduce](#MapReduce)
      - [Pig](#Pig)
      - [Hive](#Hive)
      - [Apache Ambari](#Apache-Ambari)
      - [Mesos](#Mesos)
      - [Spark](#Spark)
      - [Tez](#Tez)
      - [HBase](#HBase)
      - [Apache Storm](#Apache-Storm)
      - [Oozie](#Oozie)
      - [Zookeeper](#Zookeeper)
    - [Data Ingestion](#Data-Ingestion)
      - [Scoop](#Scoop)
      - [Flume](#Flume)
      - [Kafka](#Kafka)
    - [External Data Storage](#External-Data-Storage)
      - [MySQL](#MySQL)
      - [Cassandra and MongoDB](#Cassandra-and-MongoDB)
    - [Query Engines](#Query-Engines)
      - [Apache Drill](#Apache-Drill)
      - [Hue](#Hue)
      - [Apache Phoenix](#Apache-Phoenix)
      - [Presto](#Presto)
      - [Apache Zeppelin](#Apache-Zeppelin)

## 2. Tips for Using This Course

<https://sundog-education.com/hadoop-materials/>

## 4. Installing Hadoop

<https://grouplens.org/>

<http://127.0.0.1:8080/#/login>
maria_dev
maria_dev

SELECT movie_id, count(movie_id) as ratingCount
FROM ratings
GROUP BY movie_id
ORDER BY ratingCount
DESC;

## 5. Overview of the Hadoop Ecosystem

### Hadoop Core Stack

#### HDFS

- Hadoop distributed file system
- Storage layer

#### YARN

- Yet another resource negotiator
- Sits on top of Hadoop.
- This is where data processing comes into play.
- Manages the resources on computer cluster.

#### MapReduce

- Programming model that allows for processing data across entire cluster.
- Consists of mappers and reducers.
- Both different scripts/scripts.
- Mappers transform data in parallel across cluster.
- Reducers aggregate data across cluster.

#### Pig

- SQL like Scripting language
- A programming API
- Sits on top of MapReduce.
- Will transform script into something that can run on MapReduce which in tern goes through YARN and HDFS to get the data needed.

#### Hive

- Sits on top of MapReduce.
- Solves a similar problem to Pig.
- Takes SQL queries and makes distributed data look like a SQL d/b.
- Supports ODBC, shell queries, etc.

#### Apache Ambari

- Allows for visualization of all layers.
- Execution enabler.
- Sits on top of all other layers.
- Used by HortonWorks.
- Other alternatives available.

#### Mesos

- Not a part of Hadoop proper.
- Is a resource negotiator.
- An alternative to YARN.

#### Spark

- Sits on top of YARN or Mesos.
- At same level as MapReduce.
- Requires some programming.
- Spark scripts using Python, Java, or Scala (preferred).
- Used for data processing.
- Very powerful and versatile.
- Can handle SQL queries.
- Can handle streaming data in real-time.
- Can be used for ML across entire cluster.

#### Tez

- Similar ro Spark.
- Uses some of the same techniques as Spark.
- Uses Directed Acylic graph.
- Uses in conjunction w/ Hive to accelerate it.
- Hive can also sit on top of Tez instead of MapReduce.

#### HBase

- Sits on the side.
- NoSQL, columnar data store.
- Very fast d/b, meant for exposing data to transactional platforms.
- Used for very fast transactional rates.
- Used for hitting from web app, web sites, OLTP transactions.
- HBase can be exposed data transformed from cluster (maybe using Spark, etc.)

#### Apache Storm

- Way of processing streaming data.
- Streaming data from sensors, web logs, etc. can be processed in real-time.
- Similar to Spark streaming.
- Can update ML models, d/b etc. in real-time.

#### Oozie

- Way of scheduling jobs on cluster.
- If a task needs to happen on Hadoop cluster that involves many steps on many systems, Oozie is a way to schedule this orchestration.

#### Zookeeper

- Sits alongside.
- Way for coordinating everything.
- Which nodes are up/down.
- Tracking of shared states across different systems in the cluster.
- Used for maintaining reliable and consistent states even when nodes fail.
- Which is master node, which node is up/down, etc.

### Data Ingestion

#### Scoop

- Way of tieing Hadoop d/b into a relational d/b.
- Anything that can talk to ODBC or JDBC can be transformed into HDFS file system.
- Scoop is basically a connector between Hadoop and legacy d.bs

#### Flume

- Transporting web logs into cluster in real-time.

#### Kafka

- Can collect data of any sort from a cluster of PCs, web servers, etc. and broadcasts that into Hadoop cluster.

### External Data Storage

#### MySQL

- Using scoop data can be imported.
- Can be exported to using Spark ODBC, JDBC drivers, etc.

#### Cassandra and MongoDB

- Columnar data stores.
- Good choices for exposing data for real-time usage to say web applications, etc.
- Popular choices for K-V data stores at high transaction rates.

### Query Engines

#### Apache Drill

- Allows to write SQL queries that work across a wide range of NoSQL d/b such as HBase, Cassandra, MongoDB, etc.
- Results can be aggregated.

#### Hue

- Similar as Drill.
- Interactively query creation.
- For Cloudera works as Ambari.

#### Apache Phoenix

- Similar as Drill
- ACID compliant.
- OLTP.

#### Presto

- Yet another way to execute query across cluster

#### Apache Zeppelin

- Takes on a notebook approach to interaction w/ cluster.
