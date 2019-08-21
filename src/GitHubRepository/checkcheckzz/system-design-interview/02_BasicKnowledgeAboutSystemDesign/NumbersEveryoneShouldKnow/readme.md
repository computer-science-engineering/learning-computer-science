# Numbers Everyone Should Know

When you’re designing a performance-sensitive computer system, it is important to have an intuition for the relative costs of different operations.

1. How much does a network I/O cost, compared to 
   1. a disk I/O
   2. a load from DRAM
   3. or an L2 cache hit?
2. How much computation does it make sense to trade for a reduction in I/O?
3. What is the relative cost of random vs. sequential I/O?
4. For a given workload, what is the bottleneck resource?

When designing a system, you rarely have enough time to completely build two alternative designs to compare their performance. This makes two skills useful:

1. **Back-of-the-envelope analysis**. This essentially means developing an intuition for the performance of different alternate designs, so that you can reject possible designs out-of-hand, or choose which alternatives to consider more carefully.
2. **Microbenchmarking**. If you can identify the bottleneck operation for a given resource, then you can construct a micro-benchmark that compares the performance of different implementations of that operation. This works in tandem with your intuition: the more microbenchmarking you do, the better your intuition for system performance becomes.

Jeff Dean makes similar points in his [LADIS 2009 keynote](http://www.cs.cornell.edu/projects/ladis2009/talks/dean-keynote-ladis2009.pdf). In particular, he gives a useful table of “Numbers Everyone Should Know” — that is, the cost of some fundamental operations:

| Operation                           | Time (nsec) |
| ----------------------------------- | ----------- |
| L1 cache reference                  | 0.5         |
| Branch mispredict                   | 5           |
| L2 cache reference                  | 7           |
| Mutex lock/unlock                   | 25          |
| Main memory reference               | 100         |
| Compress 1KB bytes with Zippy       | 3,000       |
| Send 2K bytes over 1 Gbps network   | 20,000      |
| Read 1MB sequentially from memory   | 250,000     |
| Roundtrip within same datacenter    | 500,000     |
| Disk seek                           | 10,000,000  |
| Read 1MB sequentially from disk     | 20,000,000  |
| Send packet CA -> Netherlands -> CA | 150,000,000 |

Some useful figures that aren’t in Dean’s data can be found in this article [comparing NetBSD 2.0 and FreeBSD 5.3](http://www.feyrer.de/NetBSD/gmcgarry/) from 2005. Approximating those figures, we get:

| Operation                          | Time (nsec) |
| ---------------------------------- | ----------- |
| System call overhead               | 400         |
| Context switch between processes   | 3000        |
| fork() (statically-linked binary)  | 70,000      |
| fork() (dynamically-linked binary) | 160,000     |

**Update:** [This recent blog post](http://blog.tsunanet.net/2010/11/how-long-does-it-take-to-make-context.html) examines the question of system call and context switch overhead in more detail. His figures suggest the best-case system call overhead is now only ~60 nsec (for Linux on Nehelem), and that context switches cost about 30 microseconds (30,000 nsec) — when you account for the cost of flushing CPU caches, that is probably pretty reasonable.

In comparison, John Ousterhout’s [RAMCloud](http://www.stanford.edu/~ouster/cgi-bin/papers/ramcloud.pdf) project aims to provide end-to-end roundtrips for a key-value store in the same datacenter within “5-10 microseconds,” which would represent about a 100x improvement over the 500 microsecond latency suggested above.

The keynote [slides](http://www.cs.cornell.edu/projects/ladis2009/talks/dean-keynote-ladis2009.pdf) are worth a glance: Dean talks about the design of “Spanner”, a next-generation version of BigTable he is building at Google. See also [James Hamilton’s notes](http://perspectives.mvdirona.com/2009/10/17/JeffDeanDesignLessonsAndAdviceFromBuildingLargeScaleDistributedSystems.aspx) on the keynote, and [Greg Linden’s commentary](http://glinden.blogspot.com/2009/10/advice-from-google-on-large-distributed.html).

## References

1. [Numbers Everyone Should Know](https://everythingisdata.wordpress.com/2009/10/17/numbers-everyone-should-know/)
