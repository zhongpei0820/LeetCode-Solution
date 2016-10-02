// Given an integer, convert it to a roman numeral.

// Input is guaranteed to be within the range from 1 to 3999.

//Solution:

public class Solution {
    String[][] romanLetter = {
    							{"","I","II","III","IV","V","VI","VII","VIII","IX"},
                                {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
                                {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
                                {"","M","MM","MMM"}
                            };
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        return res.append(romanLetter[3][num / 1000 % 10]).append(romanLetter[2][num / 100 % 10]).append(romanLetter[1][num / 10 % 10]).append(romanLetter[0][num % 10]).toString();
        
    }
}