//
//Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T. 
//The same repeated number may be chosen from C unlimited number of times.
//Note:
//
//For example, given candidate set [2, 3, 6, 7] and target 7, 
//A solution set is: 
//[
//  [7],
//  [2, 2, 3]
//]
//

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new LinkedList<>();
        backTracking(candidates,target,new LinkedList<Integer>(), ret,0);
        return ret;
    }
    
    private void backTracking(int[] candidates,int target,List<Integer> currList,List<List<Integer>> ret,int start){
        if(target > 0){
            for(int i = start; i < candidates.length; i++){
                currList.add(candidates[i]);
                backTracking(candidates,target - candidates[i],currList,ret,i);
                currList.remove(currList.size() - 1);
            } 
        }
        else if(target == 0){
            ret.add(new LinkedList<>(currList));
        }
    }
}
