//Given a roman numeral, convert it to an integer.

//Input is guaranteed to be within the range from 1 to 3999.

//Idea: Go through the string, convert each char to an integer. Go through the list of integers, if it is greater or equal
//the next integer, add it to result. Otherwise, substract it from the result

public class Solution {
    public int romanToInt(String s) {
        char[] c = s.toCharArray();
        int[] arabic = new int[c.length];
        int result = 0;
        for(int i = 0; i < c.length; i++){
                if(c[i] == 'M') arabic[i] = 1000;
                else if(c[i] == 'D') arabic[i] = 500;
                else if(c[i] == 'C') arabic[i] = 100;
                else if(c[i] == 'L') arabic[i] = 50;
                else if(c[i] == 'X') arabic[i] = 10;
                else if(c[i] == 'V') arabic[i] = 5;
                else if(c[i] == 'I') arabic[i] = 1;
        }
        
        for(int i = 0; i < arabic.length - 1; i++){
            if(arabic[i] >= arabic[i+1]) result += arabic[i];
            else result -= arabic[i];
        }
        result += arabic[arabic.length - 1];
        return result;
    }
}

