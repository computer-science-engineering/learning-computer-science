# Indexes

* Used to improve the speed of data retrieval operations on the data store.
* Trade-offs:
  * Increased storage overhead.
  * Slower writes, since along with writing data, the index also has to be updated.
* Used to quickly locate data without having to examine every row in a database table.
* Can be created using one or more columns of a database table, providing basis for
  * rapid random lookups.
  * efficient access of ordered records.
* An index is a data structure that can be perceived as a table of contents that points us to the location where actual data lives.
* So when we create an index on a column of a table, we store that column and a pointer to the whole row in the index.
* Indexes are also used to create different views of the same data. Useful to specify different filters or sorting schemes without resorting to creating multiple additional copies of the data.
* Indexes very useful in accessing small payloads within large datasets, local or distributed.