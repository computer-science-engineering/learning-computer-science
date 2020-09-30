# Problem Definition

## Description

Given an API `read()`, this will return a string of fixed length 1024. Design another API `readn(int n)` which will return string of length n. We want to call this API multiple times on a file, and the reader is moving forward like streaming.

"ab", reada(1) -> "a", reada(1) -> "b"

## Discussion

### Approach

#### Time Complexity

#### Space Complexity

### Alternate Approach 1

#### Time Complexity - Alternate Approach 1

#### Space Complexity - Alternate Approach 1

## Notes

```java
class readApi {

  private static String lastRead;
  private int lastReadOffset;

  public String reada(int length) {
    StringBuilder sb = new StringBuilder();

    //Case : when we have reached the last block of the file.

    if(lastRead != null && lastRead.length() < 1024) {
      if(length < lastRead.length()) {
        sb.append(lastRead.substring(lastReadOffset, lastReadOffset + length));
      } else {
        sb.append(lastRead.substring(lastReadOffset));
      }

      return sb.toString();
    }

    while(length > 0) {
      lastRead = read();

      if(lastRead.length() < 1024) {
          if(length < lastRead.length()) {
            sb.append(lastRead.substring(0, length));
            lastReadOffset = length;
          } else {
            sb.append(current);
          }
          break;
      }

      sb.append(lastRead);
      length -= 1024;
    }

    return sb.toString();
  }
}
```

## References
