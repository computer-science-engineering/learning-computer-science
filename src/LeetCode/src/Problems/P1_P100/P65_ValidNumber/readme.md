# Problem Definition

## Description

Validate if a given string is numeric.

Some examples:
`"0"` => `true`
`" 0.1 "` => `true`
`"abc"` => `false`
`"1 a"` => `false`
`"2e10"` => `true`

**Note:** It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

## Notes

1. [LeetCode discussion - Java solution with one line](https://leetcode.com/problems/valid-number/discuss/24046/Java-solution-with-one-line)

    `return s.matches("(\\s*)[+-]?((\\.[0-9]+)|([0-9]+(\\.[0-9]*)?))(e[+-]?[0-9]+)?(\\s*)");`

1. [LeetCode discussion - A clean design solution By using design pattern](https://leetcode.com/problems/valid-number/discuss/23977/A-clean-design-solution-By-using-design-pattern)
1. [LeetCode discussion - Clear Java solution with ifs](https://leetcode.com/problems/valid-number/discuss/23738/Clear-Java-solution-with-ifs)

    We start with trimming.

    * If we see `[0-9]` we reset the number flags.
    * We can only see `.` if we didn't see `e` or `.`.
    * We can only see `e` if we didn't see `e` but we did see a number. We reset numberAfterE flag.
    * We can only see `+` and `-` in the beginning and after an `e`
    * any other character break the validation.

    At the and it is only valid if there was at least 1 number and if we did see an e then a number after it as well.

    So basically the number should match this regular expression:

    `[-+]?(([0-9]+(.[0-9]*)?)|.[0-9]+)(e[-+]?[0-9]+)?`

    ```java
    public boolean isNumber(String s) {
        s = s.toLowerCase().trim();
        boolean dotSeen = false;
        boolean eSeen   = false;
        boolean numberBeforeE = false;
        boolean numberAfterE  = false;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if ('0' <= cur && cur <= '9') {
                if (!eSeen) numberBeforeE = true;
                if (eSeen)  numberAfterE  = true;
            } else if (cur == '-' || cur == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
            } else if (cur == '.') {
                if (eSeen || dotSeen) return false;
                dotSeen = true;
            } else if (cur == 'e' ) {
                if (eSeen) return false;
                eSeen = true;
            } else { // invalid chars
                return false;
            }
        }
        return eSeen ? (numberBeforeE && numberAfterE) : numberBeforeE;
    }
    ```