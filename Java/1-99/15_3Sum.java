// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

// Note: The solution set must not contain duplicate triplets.

// For example, given array S = [-1, 0, 1, 2, -1, -4],

// A solution set is:
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]


//Solution: 
// First we read A[k], and find if there is A[i] + A[j] = 0 - A[k], so This problem can be reduced to 2Sum where the target is 0 - A[k].
// Because the answer should not contain any duplicate triplets, so we can sort this array and jump over the duplicate elements. 
// For example S = [-1, 0 1, 2, -1, -4] => [-4, -1, -1, 0, 1, 2]. 
// S[0] = -4, and the target is 4. We need to find if there is two numbers sum up to 4 in [-1, -1, 0, 1, 2]. Then we have all the possible combination contains -4.
// S[1] = -1, because we have already find all possible combinations contians -4, now we only have to two numbers sum up to 1 in [-1, 0, 1, 2].
// S[2] = S[1] = -1, so we igonre it and jump tp S[3]. 
// And so on so forth.

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new LinkedList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2;){
            if(nums[i] > 0) break;
            int low = i + 1, high = nums.length - 1;
            while(low < high){
                int sum = nums[i] + nums[high] + nums[low];
                if(sum == 0) ret.add(Arrays.asList(nums[i],nums[low],nums[high]));
                if(sum <= 0) while(low < high && nums[low] == nums[++low]);
                if(sum >= 0) while(low < high && nums[high] == nums[--high]);
            }
            while(i < nums.length - 2 && nums[i] == nums[++i]);  
        }
        return ret;
    }
}