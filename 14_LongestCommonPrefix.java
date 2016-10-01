//Write a function to find the longest common prefix string amongst an array of strings.

//For example: {"Leet","Leetcode","LeetC","Lee"} => "Lee"

//Solution 1:
//First we observe the longest common prefix is contained in every string.
//Then, if the common prefix of the first two strings is LCS(str[0],str[1]), the common prefix of the first three strings is LCS(LSC(str[0],str[1]),str[3]).
//So, we first find the common prefix of str[0] and str[1], then compare this prefix with str[3] to find the common prefix of the first three strings, and so no so forth.
///From this observation, the common prefix of n strings is LCS(LCS(LCS(...(LCS(str[0],str[1])...,str[n-3]),str[n-2]),str[n-1]),str[n]).
//For instance:
//
//1. Compare "Leet" with "Leetcode", and the common prefix is "Leet". 
//2. Update current prefix = "Leet".
//3. Compare current prefix with "LeetC", and the common prefix is "Leet".
//4. Compare current prefix with "Lee", and the common prefix is "Lee".
//5. The longest common prefix is "Lee".

//However, this approach may cost O(S) time complexity at worst case, where S is the sum of all characters in all string.

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String prefix = strs[0];
        for(int i = 0; i < strs.length; i++){
            int index = 0;
            while(index < strs[i].length() && index < prefix.length() && strs[i].charAt(index) == prefix.charAt(index)){
                index++;
            }
            prefix = prefix.substring(0,index);
        }
        return prefix;
    }
}

//One way to improve this solution is using divide and conquer. Now that we know that LCS(LCS(str[0],str[1])...str[n]),
//We can also do LCS(LCS(str[0],...,str[n/2]),LCS(str[n/2+1],...,LCS[n])).
