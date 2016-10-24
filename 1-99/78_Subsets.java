// Given a set of distinct integers, nums, return all possible subsets.

// Note: The solution set must not contain duplicate subsets.

// For example,
// If nums = [1,2,3], a solution is:

// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]

// Solution:
// Bit Manipulation or BackTrack
// Bit : 000 means dont take 3, dont take 2 and don take 1.
// 		 001 measn dont take 3, dont takek 2 and take 1.
// 		 So on so forth.
// There are only 2^3 conmbinations.

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new LinkedList<>();
        int total = 1 << nums.length;
        for(int i = 0; i < total; i++){
            List<Integer> list = new LinkedList<>();
            for(int j = 0; j < nums.length; j++){
                if( (1 & (i >>> j)) == 1) list.add(nums[j]);
            }
            ret.add(list);
        }
        return ret;
    }
}

// Solution 2 : BackTracking.

// See this as a tree, and use dfs.
//                         []
//             [1]                       []
//       [1,2]       [1]             [2]    []
// [1,2,3] [1,2] [1,3] [1]       [2,3] [2] [3] []

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        dfs(ret,list,0,nums);
        return ret;
    }
    
    private void dfs(List<List<Integer>> ret, List<Integer> list, int pos, int[] nums){
        if(pos == nums.length){
            ret.add(list);
        }else{
            List<Integer> left = new LinkedList<>();
            List<Integer> right = new LinkedList<>();
            left.addAll(list);
            dfs(ret,left,pos + 1,nums);
            right.addAll(list);
            right.add(nums[pos]);
            dfs(ret,right,pos + 1,nums);
        }
    }
}