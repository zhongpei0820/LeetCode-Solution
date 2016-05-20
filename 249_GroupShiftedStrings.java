// Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

// "abc" -> "bcd" -> ... -> "xyz"
// Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

// For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
// Return:

// [
//   ["abc","bcd","xyz"],
//   ["az","ba"],
//   ["acef"],
//   ["a","z"]
// ]

//Idea: The strings in the same group can be shifted to a same string. For example, all strings in ["abc", "bcd", "xyz"] can be shifted to "xyz".
//      Define a offset which eqaul to the defference between first char in a string and 'z', which means we shift the string to "z..."
//      And we use "z..." as the hash key to classify each group. All strings have the same key will be put into the same group.

public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap();
        for(int i = 0; i < strings.length; i++){
            String key = getKey(strings[i]);
            if(map.containsKey(key)){
                map.get(key).add(strings[i]);
            }else{
                List<String> list = new ArrayList<>();
                list.add(strings[i]);
                map.put(key,list);
            }
        }
        for(List<String> list : map.values()){
            list.sort(null);
            res.add(list);
        }
        return res;
    }
    
    public String getKey(String str){
        if(str.length() == 0){
            return "";
        }
        if(str.length() == 1){
            return "z";
        }
        char[] c = str.toCharArray();
        int offset = 'z' - c[0];
        for(int i = 0; i < c.length; i++){
            c[i] += offset;
            if(c[i] > 'z'){
                c[i] -= 26;
            }
        }
        return String.valueOf(c);
    }
}
