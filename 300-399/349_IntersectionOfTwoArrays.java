//Given two arrays, write a function to compute their intersection.

//Example:
//Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

//Note:
//Each element in the result must be unique.
//The result can be in any order.

//Idea:HashTable

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int i = 0; i < nums1.length; i++){
            set1.add(nums1[i]);
        }
        
        for(int i = 0; i < nums2.length; i++){
            if(set1.contains(nums2[i])){
                set2.add(nums2[i]);
            }
        }
        
        int i = 0;
        int[] result = new int[set2.size()];
        for(int num : set2){
            result[i++] = num;
        }
        return result;
        
    }
}
