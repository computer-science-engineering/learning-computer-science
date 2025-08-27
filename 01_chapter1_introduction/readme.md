# Chapter 1: Introduction

1. [What As a Log](#what-as-a-log)

## What As a Log

- log — a series of loosely structured requests, errors, or other messages in a sequence of rotating text files.
- Application logs: meant for humans to read.
- Logs here: for programmatic access.
- Humans reading through many logs is unmanageable and is a tedious exercise to extract meaningful information. So the purpose of logs is to feed into processing systems of queries and graph that can understand behavior across machines.
- Logs in the book: commit log or journal - from database or systems world. Append-only system of records ordered by time.
- Each entry appended to teh log is assigned a unique, sequential log entry number that acts as its unique key.
- The ordering of records defines a notion of “time” since entries to the left are defined to be older then entries to the right. The log entry number can be thought of as the “timestamp” of the entry.
- convenient property of being decoupled from any particular physical clock. Useful in distributed systems.
- A file is an array of bytes, a table is an array of records, and a log is really just a kind of table or file where the records are sorted by time.

## Logs in Databases
