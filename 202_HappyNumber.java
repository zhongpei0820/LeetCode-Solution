// Write an algorithm to determine if a number is "happy".

// A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

// Example: 19 is a happy number

// 12 + 92 = 82
// 82 + 22 = 68
// 62 + 82 = 100
// 12 + 02 + 02 = 1

//Idea: If the number is not happy number, it loops endlessly, which means same number appears repeatedly.
//HashSet can be used to check the duplicate number.

public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        while(n != 1){
            n = squareSum(n);
            if(!set.add(n)) return false;
        }
        return true;
    }
    
    public int squareSum(int n){
        int sum = 0;
        while(n != 0){
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    }
}
