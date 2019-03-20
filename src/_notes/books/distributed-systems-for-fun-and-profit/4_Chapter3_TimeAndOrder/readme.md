# Time and order

- [Time and order](#time-and-order)
  - [Total and partial order](#total-and-partial-order)
  - [What is time](#what-is-time)
    - [Does time progress at the same rate everywhere](#does-time-progress-at-the-same-rate-everywhere)

What is order?

We described distributed programming as the art of solving the same problem that you can solve on a single computer using multiple computers.

This is, in fact, at the core of the obsession with order. Any system that can only do one thing at a time will create a total order of operations. Every operation will have a well-defined predecessor and successor. That's basically the programming model that we've worked very hard to preserve.

Order as a property has received so much attention because the easiest way to define "correctness" is to say "it works like it would on a single machine". And that usually means that a) we run the same operations and b) that we run them in the same order - even if there are multiple machines.

The nice thing about distributed systems that preserve order (as defined for a single system) is that they are generic. You don't need to care about what the operations are, because they will be executed exactly like on a single machine. This is great because you know that you can use the same system no matter what the operations are.

In reality, a distributed program runs on multiple nodes; with multiple CPUs and multiple streams of operations coming in. You can still assign a total order, but it requires either accurate clocks or some form of communication. You could timestamp each operation using a completely accurate clock then use that to figure out the total order. Or you might have some kind of communication system that makes it possible to assign sequential numbers as in a total order.

## Total and partial order

The natural state in a distributed system is [partial order](http://en.wikipedia.org/wiki/Partially_ordered_set). Neither the network nor independent nodes make any guarantees about relative order; but at each node, you can observe a local order.

A [total order](http://en.wikipedia.org/wiki/Total_order) is a binary relation that defines an order for every element in some set.

Two distinct elements are **comparable** when one of them is greater than the other. In a partially ordered set, some pairs of elements are not comparable and hence a partial order doesn't specify the exact order of every item.

Both total order and partial order are [transitive](http://en.wikipedia.org/wiki/Transitive_relation) and [anti-symmetric](http://en.wikipedia.org/wiki/Antisymmetric_relation). The following statements hold in both a total order and a partial order for all a, b and c in X:

If a ≤ b and b ≤ a then a = b (antisymmetry);
If a ≤ b and b ≤ c then a ≤ c (transitivity);

However, a total order is total:

a ≤ b or b ≤ a (totality) for all a, b in X

while a partial order is only [reflexive](http://en.wikipedia.org/wiki/Reflexive_relation):

a ≤ a (reflexivity) for all a in X

Note that totality implies reflexivity; so a partial order is a weaker variant of total order. For some elements in a partial order, the totality property does not hold - in other words, some of the elements are not comparable.

Git branches are an example of a partial order. As you probably know, the git revision control system allows you to create multiple branches from a single base branch - e.g. from a master branch. Each branch represents a history of source code changes derived based on a common ancestor:

```text
[ branch A (1,2,0)]  [ master (3,0,0) ]  [ branch B (1,0,2) ]
[ branch A (1,1,0)]  [ master (2,0,0) ]  [ branch B (1,0,1) ]
                  \  [ master (1,0,0) ]  /
```

The branches A and B were derived from a common ancestor, but there is no definite order between them: they represent different histories and cannot be reduced to a single linear history without additional work (merging). You could, of course, put all the commits in some arbitrary order (say, sorting them first by ancestry and then breaking ties by sorting A before B or B before A) - but that would lose information by forcing a total order where none existed.

In a system consisting of one node, a total order emerges by necessity: instructions are executed and messages are processed in a specific, observable order in a single program. We've come to rely on this total order - it makes executions of programs predictable. This order can be maintained on a distributed system, but at a cost: communication is expensive, and time synchronization is difficult and fragile.

## What is time

Time is a source of order - it allows us to define the order of operations - which coincidentally also has an interpretation that people can understand (a second, a minute, a day and so on).

Assuming that time progresses at the same rate everywhere - and that is a big assumption which we'll return to in a moment - time and timestamps have several useful interpretations when used in a program. The three interpretations are:

- Order
- Duration
- Interpretation

_Order_. When I say that time is a source of order, what I mean is that:

- we can attach timestamps to unordered events to order them
- we can use timestamps to enforce a specific ordering of operations or the delivery of messages (for example, by delaying an operation if it arrives out of order)
- we can use the value of a timestamp to determine whether something happened chronologically before something else

_Interpretation_ - time as a universally comparable value. The absolute value of a timestamp can be interpreted as a date, which is useful for people. Given a timestamp of when a downtime started from a log file, you can tell that it was last Saturday, when there was a thunderstorm.

_Duration_ - durations measured in time have some relation to the real world. Algorithms generally don't care about the absolute value of a clock or its interpretation as a date, but they might use durations to make some judgment calls. In particular, the amount of time spent waiting can provide clues about whether a system is partitioned or merely experiencing high latency.

By their nature, the components of distributed systems do not behave in a predictable manner. They do not guarantee any specific order, rate of advance, or lack of delay. Each node does have some local order - as execution is (roughly) sequential - but these local orders are independent of each other.

Imposing (or assuming) order is one way to reduce the space of possible executions and possible occurrences. Humans have a hard time reasoning about things that can happen in any order - there just are too many permutations to consider.

### Does time progress at the same rate everywhere