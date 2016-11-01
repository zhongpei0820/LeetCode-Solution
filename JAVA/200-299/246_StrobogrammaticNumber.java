// A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

// Write a function to determine if a number is strobogrammatic. The number is represented as a string.

// For example, the numbers "69", "88", and "818" are all strobogrammatic.

//Idea: The number must consisted of 0,1,6,8,9. Replace 6 with 9 and 9 with 6, then reverse the number, it will be the same.

public class Solution {
    public boolean isStrobogrammatic(String num) {
        char[] c = num.toCharArray();
        char[] c1 = new char[c.length];
        for(int i = 0; i < c.length; i++){
            if(c[i] != '0' && c[i] != '1' && c[i] != '6' && c[i] != '8' && c[i] != '9') return false;
            if(c[i] == '6') c1[c.length - 1 - i] = '9';
            else if(c[i] == '9') c1[c.length - 1 - i] = '6';
            else c1[c.length - 1- i] = c[i];
        }
        return (String.valueOf(c1).equals(num));
        
    }
}
