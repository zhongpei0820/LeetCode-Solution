// Given a digit string, return all possible letter combinations that the number could represent.

// A mapping of digit to letters (just like on the telephone buttons) is given below.



// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

public class Solution {
    
    String[][] digitMap = {
        {"a","b","c"},
        {"d","e","f"},
        {"g","h","i"},
        {"j","k","l"},
        {"m","n","o"},
        {"p","q","r","s"},
        {"t","u","v"},
        {"w","x","y","z"}
    };
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if(digits.length() == 0) return res;
        Queue<String> q = new LinkedList<>();
        q.add("");
        for(int i = 0; i < digits.length(); i++){
            int size = q.size();
            for(int k = 0; k < size; k++){
                String temp = q.poll();
                for(int j = 0; j < digitMap[digits.charAt(i) - '2'].length; j++){
                    q.add(temp + digitMap[digits.charAt(i) - '2'][j]);
                }
            }
        }
        res.addAll(q);
        return res;
    }
}