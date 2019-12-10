# Problem Definition

## Description

Function takes 2 strings, message and code. Returns a boolean indicating whether can create a 1:1 mapping between words in message and letters in code (can encode/decode message with code).

**Examples:**

```plaintext
"red green blue", "abc" --> True
"red green blue", "abb" --> False
"red blue blue", "abb" --> True

"red blue red", "ab" --> False
"red blue red", "abaa" --> False
```

## Notes