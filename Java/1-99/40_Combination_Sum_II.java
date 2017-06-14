//
//Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//Each number in C may only be used once in the combination.
//Note:
//
//For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
//A solution set is: 
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
//

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new LinkedList<>();
        Arrays.sort(candidates);
        backTracking(candidates,target,0,new LinkedList<Integer>(),ret);
        return ret;
    }
    
    private void backTracking(int[] candidates,int target,int start,List<Integer> curr,List<List<Integer>> ret){
        if(target == 0){
            ret.add(new LinkedList<>(curr));
            return;
        }
        if(target > 0){
            for(int i = start; i < candidates.length; i++){
                if(candidates[i] > target) break;
                if(i > start && candidates[i] == candidates[i - 1]) continue;
                curr.add(candidates[i]);
                backTracking(candidates,target - candidates[i],i + 1,curr,ret);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
