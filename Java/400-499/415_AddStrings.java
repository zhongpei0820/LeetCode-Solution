// Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.

// Note:

// The length of both num1 and num2 is < 5100.
// Both num1 and num2 contains only digits 0-9.
// Both num1 and num2 does not contain any leading zero.
// You must not use any built-in BigInteger library or convert the inputs to integer directly.

// Solution: Iterate two strings from right to left, and append sum of each char to the res, return res.reverse()

public class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        StringBuilder res = new StringBuilder();
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--,j--){
            int val1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int val2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            res.append((val1 + val2 + carry) % 10);
            carry = (val1 + val2 + carry) / 10;
        }
        if(carry != 0) res.append(carry);
        return res.reverse().toString();
    }
}