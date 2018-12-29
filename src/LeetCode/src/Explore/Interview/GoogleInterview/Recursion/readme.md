# Recursion

Recursion usually involve some kind of backtracking to enumerate all possibilities.

Note that [Backtracking](http://en.wikipedia.org/wiki/Backtracking) is a more general purpose algorithm. [Depth-First search](http://en.wikipedia.org/wiki/Depth-first_search) is a specific form of backtracking related to searching tree structures. Therefore we categorize those problems in "Trees and Graphs", even though they involve recursion.

There are usually some smart pruning techniques which optimizes backtracking. For a great introduction of how pruning works, take a look at [this article](https://secweb.cs.odu.edu/~zeil/cs361/web/website/Lectures/styles/pages/ar01s04s05.html). A great example is "Word Search II" (aka the Boggle solver), which uses a data structure to optimize the search.