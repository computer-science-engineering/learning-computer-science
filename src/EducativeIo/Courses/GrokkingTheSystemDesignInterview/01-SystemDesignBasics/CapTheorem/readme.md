# CAP Theorem

States that impossible for a distributed software system to simultaneously provide more than two out of three of the following guarantees (CAP):

* Consistency
* Availability
* Partition tolerance.

## Consistency

* All nodes see the same data at the same time.
* Achieved by updating several nodes before allowing further reads.

## Availability

* Every request gets a response on success/failure.
* Achieved by replicating data across different servers.

## Partition tolerance

* System continues to work despite message loss or partial failure.
* A fault-tolerant system can sustain any amount of network failure that doesn't result in a failure of the entire network.
* Data is sufficiently replicated across combinations of nodes and networks to keep the system up through intermittent outages.

```AsciiArt

                          *** ### ### ***          *** ### ### ***
                      *##                 ##*  *##                 ##*
                  *##                      *####*                      ##*
               *##                      *##      ##*      Consistency     ##*
             *##  Availability        *##          ##*                      ##*
           *##                      *##   RDBMS      ##*                      ##*
          *##                      *##                ##*                      ##*
         *##                      *##                  ##*                      ##*
        *##                      *##    *** ### ### *** ##*                      ##*
        *##                      *##*##                 ##*                      ##*
        *##                     *###                    ##* ##*                  ##*
        *##                  *## *##      Not possible  ##*    ##*               ##*
        *##                *##   *##                    ##*      ##*             ##*
         *##             *##      *##                  ##*         ##*          ##*
          *##           *##        *##                ##*           ##*        ##*
           *##         *##          *##              ##* BigTable,   ##*      ##*
             *##      *##  Cassandra, *##          ##*   MongoDB,     ##*   ##*
               *#     *##  CouchDb      *#       ##*     HBase        ##* ##*
                  *## *##                  *####*                     ##**
                      *##                 ##*  *##                 ##*##*
                      *## *** ### ### ***          *** ### ### ***    ##*
                       *##                                           ##*
                        *##          Partition Tolerance            ##*
                         *##                                       ##*
                           *##                                   ##*
                             *#                                ##*
                                *##                         ##*
                                    *##                 ##*
                                        *** ### ### ***

```