// Write a function that takes a string as input and reverse only the vowels of a string.

// Example 1:
// Given s = "hello", return "holle".

// Example 2:
// Given s = "leetcode", return "leotcede".

//Idea: Traverse the string with two pointers, one traverses from the beginning and one traverses from the end.
//Swap if both pointers are pointing at vowels.

public class Solution {
    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        int i = 0, j = c.length - 1;
        while(i < j){
            if(isVowel(c[i]) && isVowel(c[j])){
                swap(c,i,j);
                i++;
                j--;
            }
            if(!isVowel(c[i])) i++;
            if(!isVowel(c[j])) j--;
        }
        return String.valueOf(c);
            
    }
    
    public boolean isVowel(char c){
        if(c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') return false;
        else return true;
    }
    
    public void swap(char[] c,int i, int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}


