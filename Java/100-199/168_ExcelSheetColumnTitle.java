// Given a positive integer, return its corresponding column title as appear in an Excel sheet.

// For example:

//     1 -> A
//     2 -> B
//     3 -> C
//     ...
//     26 -> Z
//     27 -> AA
//     28 -> AB 


// Solution:
// n % 26 = 1  -> A -> 'A' + 0  -> 'A' + (n-1) % 26
// n % 26 = 2  -> B -> 'A' + 1  -> 'A' + (n-1) % 26
// n % 26 = 3  -> C -> 'A' + 2  -> 'A' + (n-1) % 26
// n % 26 = 4  -> D -> 'A' + 3  -> 'A' + (n-1) % 26
// ...
// n % 26 = 24 -> Y -> 'A' + 23 -> 'A' + (n-1) % 26
// n % 26 = 25 -> X -> 'A' + 24 -> 'A' + (n-1) % 26
// n % 26 = 0  -> Z -> 'A' + 25 -> 'A' + (n-1) % 26

// Example: n = 27.
// (27 - 1) % 26 = 0. Last char = 'A' + 0 = 'A'.
// 27 - 1 = 26. (minus 1 because if n = 26. 26 / 26 = 1. Then the answer will be 'AZ').
// 26 / 26 = 1.
// (1 -1 ) % 26 = 0. Second char = 'A' + 0 = 'A'.
// Finally 'A' + 'A' = "AA".


// While n > 0 : (--n) % 26 , n = n / 26.

public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            char c = (char)(--n % 26 + 'A');
            sb.insert(0,c);
            n /= 26; 
        }
        return sb.toString();
    }
}