// Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

// For example:

// Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

// Follow up:
// Could you do it without any loop/recursion in O(1) runtime?

// Solution:
// If num = xyz = x * 100 + y * 10 + z = x + y + z + 99 * x + 9 * y.
// So num % 9 = xyz % 9 = (x + y + z) % 9.
// If x + y + z > 9, say ab = (x + y + z). Then ab % 9 = (a + b) % 9 = (x + y + z) % 9 = xyz % 9
// Note that if xyz % 9 == 0, it should return 9 rather than 0.


public class Solution {
    public int addDigits(int num) {
        if(num == 0) return 0;
        if(num % 9 == 0) return 9;
        return num % 9;
    }
}

// A shorter version:

public class Solution {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}