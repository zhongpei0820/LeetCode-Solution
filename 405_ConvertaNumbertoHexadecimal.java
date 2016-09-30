public class Solution {
    
    String[] hex = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
    
    public String toHex(int num) {
        if(num == 0) return "0";
        String ret = "";
        while(num != 0){
            ret = hex[num & 15] + ret;
            num >>>= 4;
        }
        return ret;
    }
}
