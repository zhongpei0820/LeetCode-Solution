// Implement strStr().

// Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

//Solution:  One solution is kmp. A more brute way is iteration over these two strings.
//			 Use two pointers i and j.
//For example: haystack : abcabcdabc
//			   needle   : abcd
//   		   i = 0; j = 0; haystack[i + j] ==  needle[j].
// 			   i = 0; j = 1; haystack[i + j] ==  needle[j].
//  		   i = 0; j = 2; haystack[i + j] ==  needle[j].
//  		   i = 0; j = 3; haystack[i + j] !=  needle[j]. => i = i + 1;

//             ...

// 			

//             haystack : abcabcdabc
//			   needle   :    abcd

//   		   i = 3; j = 0; haystack[i + j] ==  needle[j].
// 			   i = 3; j = 1; haystack[i + j] ==  needle[j].
//  		   i = 3; j = 2; haystack[i + j] ==  needle[j].
//  		   i = 3; j = 3; haystack[i + j] ==  needle[j]. 
// 			   i = 3; j = 4; j == needle.length; break; return i;

// 			   if i + j == haystack.length; return -1.


public class Solution {
    public int strStr(String haystack, String needle) {
        for(int i = 0; ;i++){
            for(int j = 0; ; j++){
                if(j == needle.length()) return i;
                if(i + j == haystack.length()) return -1;
                if(haystack.charAt(i + j) != needle.charAt(j)){ i = j == 0 ? i : i + j - 1; break;}
            }
        }
    }
}


