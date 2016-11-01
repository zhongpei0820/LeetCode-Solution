// An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

// a) it                      --> it    (no abbreviation)

//      1
// b) d|o|g                   --> d1g

//               1    1  1
//      1---5----0----5--8
// c) i|nternationalizatio|n  --> i18n

//               1
//      1---5----0
// d) l|ocalizatio|n          --> l10n
// Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

// Example: 
// Given dictionary = [ "deer", "door", "cake", "card" ]

// isUnique("dear") -> false
// isUnique("cart") -> true
// isUnique("cane") -> false
// isUnique("make") -> true

// Solution:
// We can use a hash table to store abbr as the key and str as the value.
// If two strings in the dictionary have the same abbr, then set the str of that key to "". (means this abbr is not unique already).
// Then check each input str with this hash table. 
// Note that ["hello"].isUnique("hello") is true, because the two strs are the same.

public class ValidWordAbbr {
    
    HashMap<String,String> map;

    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for(String str : dictionary){
            String abbr = convertAbbr(str);
            if(map.containsKey(abbr) && !map.get(abbr).equals(str)) map.put(abbr,"");
            else map.put(abbr,str);
        }
    }

    public boolean isUnique(String word) {
        String abbr = convertAbbr(word);
        return !map.containsKey(abbr) || map.get(abbr).equals(word);
    }
    
    private String convertAbbr(String str){
        if(str.length() <= 2) return str;
        else{
            StringBuilder sb = new StringBuilder();
            sb.append(str.charAt(0)).append(str.length() - 2).append(str.charAt(str.length() - 1));
            return sb.toString();
        }
    }
}
