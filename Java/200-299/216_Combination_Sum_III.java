//Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers. Example 1:Input:  k = 3,  n = 7Output: [[1,2,4]]
// Example 2:Input:  k = 3,  n = 9Output: [[1,2,6], [1,3,5], [2,3,4]]
//Credits:Special thanks to @mithmatt for adding this problem and creating all test cases.

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new LinkedList<>();
        backTracking(k,n,1,new LinkedList<Integer>(), ret);
        return ret;
    }
    
    private void backTracking(int k, int n, int start,List<Integer> curr,List<List<Integer>> ret){
        // if(n > 9 * k || n < k) return;
        if(n == 0 && k == 0){
            ret.add(new LinkedList<Integer>(curr));
            return;
        }
        if(n > 0 && k > 0){
            int end = Math.min(n / k + 1, 10);
            for(int i = start; i < end; i++){
                curr.add(i);
                backTracking(k - 1,n - i,i + 1,curr,ret);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
