//
//Given a collection of distinct numbers, return all possible permutations.
//
//For example,
//[1,2,3] have the following permutations:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
//

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        backTracing(0,nums,list,ret);
        return ret;
    }
    
    private static void backTracing(int index, int[] nums, List<Integer> list, List<List<Integer>> ret){
        if(index == nums.length){
            ret.add(new LinkedList<>(list));
            return;
        }
        for(int i = 0; i <= list.size(); i++){
            list.add(i,nums[index]);
            backTracing(index + 1,nums,list,ret);
            list.remove(i);
        }
    }
}
