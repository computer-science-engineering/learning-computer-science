# Problem Definition

## Description

Given a log of website requests, where each request entry contains `<timestamp, customerId, visitedPageId>` find the top 3-page sequence visited.

Ex, We have 2 customers, `A` visits pages `A->B->C->D->E` and `B` visits `E->B->C->shoppingCartPage->homepage`, then the top 3-page sequence is `B->C->D`

```text
ts, abc, A
ts, abc, D
ts, xyz, B
ts, abc, B
```

```text
A -> A, [A,B], [A,B,C], [B,C,D], [ l, m, n, o, p]
B ->
```

```text
a,b,c -> 1
b,c,d -> 2
c,d,e -> 1
e,b,c -> 1
c,d,a -> 1
```

## Notes