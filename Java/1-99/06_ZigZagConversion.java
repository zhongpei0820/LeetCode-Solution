// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

// P   A   H   N
// A P L S I I G
// Y   I   R
// And then read line by line: "PAHNAPLSIIGYIR"
// Write the code that will take a string and make this conversion given a number of rows:

// string convert(string text, int nRows);
// convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

// Solution: 
// First we note that zigzag pattern is consisted with two parts: vertiaclly down and obliquely up.
// And each column contains n characters when it goes down and n - 2 characters when goes up.
// Use an array of StringBuilder for each row, and iterate the orginal string.
// when it goes down, i < numRows, and StringBuilder[i] = s.charAt(j), i++,j++.
// when it goes up, i > 0, and StringBuilder[i] = s.charAt(j), i--,j++.

public class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] strRows = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) strRows[i] = new StringBuilder();
        for(int i = 0; i < s.length();){
            for(int j = 0; j < numRows && i < s.length(); j++) strRows[j].append(s.charAt(i++));
            for(int j = numRows - 2; j > 0 && i < s.length(); j--) strRows[j].append(s.charAt(i++));
        }
        StringBuilder ret = new StringBuilder();
        for(int i = 0; i < numRows; i++) ret.append(strRows[i]);
        return ret.toString();
    }
}