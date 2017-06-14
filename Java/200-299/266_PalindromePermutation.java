// Given a string, determine if a permutation of the string could form a palindrome.

// For example,
// "code" -> False, "aab" -> True, "carerac" -> True.


// 2ms Solution:
public class Solution {
    public boolean canPermutePalindrome(String s) {
        HashSet<Character> set = new HashSet<Character>();
        for(char c : s.toCharArray())
            if(!set.add(c)) set.remove(c);
        return set.size() == 0 || set.size() == 1;
     }
}

// 0ms Solution:
public class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] bucket = new int[256];
        int odd_count = 0;
        for(char c : s.toCharArray()){
            bucket[c]++;
            if(bucket[c] % 2 == 1) odd_count++;
            else odd_count--;
        }
        return odd_count <= 1;
     }
}