// Related to question Excel Sheet Column Title
// Given a column title as appear in an Excel sheet, return its corresponding column number.
// For example:
//     A -> 1
//     B -> 2
//     C -> 3
//     ...
//     Z -> 26
//     AA -> 27
//     AB -> 28 

//Idea: 26 binary 

public class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        char[] c = s.toCharArray();
        for(int i = 0; i < c.length; i++){
            result += (c[i] - 'A' + 1)*Math.pow(26,c.length-1-i);
        }
        return result;
    }
}
