// Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

// Example:
// Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])


// Solution : DP and Math
// Let res[i] represent the number of unique numbers among i digits.
// For example: 
// res[0] = 1, since there is only 0.
// res[1] = 9, because all one-digit numbers is unique digit : 1,2,3,4,5,6,7,8,9.
// res[2] = 81, among all two-digit numbers (10 - 99), the number with unique digits = 9 * 9 
// the first digit is chosen from (1,2,3,4,5,6,7,8,9), so there are 9 choices,
// the second digit is chosen from (0,1,2,3,4,5,6,7,8,9) except the one has been chosen as the first digit, so there are 9 choices.
// res[3] = 9 * 9 * 8 = 648
// res[4] = 9 * 9 * 8 * 7.
// And so on so forth.
// The result is the sum from res[0] to res[n],

public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int res[] = new int[n + 1];
        res[0] = 1;
        int sum = 1;
        int k = 9;
        for(int i = 1; i <= n && k > 0; i++){
               if(i == 1) res[i] += res[i - 1] * 9;
               else res[i] += res[i - 1] * k--;
               sum += res[i];
        }
        return sum;
    }
}