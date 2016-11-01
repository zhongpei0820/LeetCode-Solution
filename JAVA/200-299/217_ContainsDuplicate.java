//Given an array of integers, find if the array contains any duplicates. 
//Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

//Idea:hashmap

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> hashmap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!hashmap.containsKey(nums[i])){
                hashmap.put(nums[i],nums[i]);
            }else{
                return true;
            }
        }
        return false;
    }
}
