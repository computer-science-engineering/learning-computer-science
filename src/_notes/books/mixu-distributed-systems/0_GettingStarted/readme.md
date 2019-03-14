# Distributed Systems

## Introduction

In my view, much of distributed programming is about dealing with  implications of two consequences of distribution:

* that information travels at the speed of light
* that independent things fail independently*

In other words, that the core of distributed programming is dealing  distance (duh!) and having more than one thing (duh!). These define a space of possible system designs, and my hope is that after reading this you'll have a better sense of how distance, time and consistency models
interact.

## 1. Basics