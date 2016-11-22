//
//Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
//If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//
//The replacement must be in-place, do not allocate extra memory.
//
//Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
//1,2,3 → 1,3,2
//3,2,1 → 1,2,3
//1,1,5 → 1,5,1
//

public class Solution {
    public void nextPermutation(int[] nums) {
        int k = -1;
        int len = nums.length;
        for(int i = len - 2; i > -1; i--){
            if(nums[i] < nums[i + 1]){
                 k = i;
                 break;
            }
        }
        if(k == -1){
           reverse(0,len - 1,nums);
           return;
        } 
        int l = -1;
        for(int i = len - 1; i > k; i--){
            if(nums[i] > nums[k]){
                l = i;
                break;
            }
        }
        swap(l,k,nums);
        reverse(k + 1,len - 1,nums);
        return;
    }
    
    private void swap(int index1, int index2, int[] nums){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    
    private void reverse(int start,int end,int[] nums){
        while(start < end){
           swap(start++,end--,nums);
        }
    }
}
