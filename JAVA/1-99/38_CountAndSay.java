// The count-and-say sequence is the sequence of integers beginning as follows:
// 1, 11, 21, 1211, 111221, ...

// 1 is read off as "one 1" or 11.
// 11 is read off as "two 1s" or 21.
// 21 is read off as "one 2, then one 1" or 1211.
// Given an integer n, generate the nth sequence.

// Note: The sequence of integers will be represented as a string.

// Solution:
// The key to this problem is how to count the string.
// We can do it by using two pointers i and j.
// For example:
// i         i == j    i             i != j
// 1 2 1 1  ========>  1 2 1 1 ==================> ...
// j         count++     j       ret = count + i
//             j++                    i = j

// If str[i] == str[j], count = count + 1, and move j to the next character.
// If str[i] != str[j], reslut = String.valueOf(count) + str[i]. And move i to j.


public class Solution {
    public String countAndSay(int n) {
        int i = 1;
        String str = "1";
        if(n == 1) return str;
        while(i < n){
            str = helper(str);
            i++;
        }
        return str;
    }
    
    public String helper(String str){
        StringBuilder sb = new StringBuilder();
        int i = 0,j = 0;
        while(i < str.length() && j < str.length()){
            int count = 0;
            while(j < str.length() && str.charAt(i) == str.charAt(j)){
                count++;
                j++;
            }
            sb.append(count);
            sb.append(str.charAt(i));
            i = j;
        }
        return sb.toString();
    }
}