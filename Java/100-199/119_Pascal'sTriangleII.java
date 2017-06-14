// Given an index k, return the kth row of the Pascal's triangle.

// For example, given k = 3,
// Return [1,3,3,1].

//Use two list to store the current line and the last line.

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < rowIndex + 1; i++){
            List<Integer> temp = new ArrayList<>();
            temp.addAll(res);
            res.clear();
            for(int j = 0; j < i + 1; j++){
                if(j == 0 || j == i) res.add(1);
                else res.add(temp.get(j - 1) + temp.get(j));
            }
        }
        return res;
    }
}
