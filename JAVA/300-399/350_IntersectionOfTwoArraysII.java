// Given two arrays, write a function to compute their intersection.

// Example:
// Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

// Note:
// Each element in the result should appear as many times as it shows in both arrays.
// The result can be in any order.
// Follow up:
// What if the given array is already sorted? How would you optimize your algorithm?
// What if nums1's size is small compared to num2's size? Which algorithm is better?
// What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

//Idea: 1. HashMap, using nums[i] as the key and number of each element as value;
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums1.length; i++){
            if(!map.containsKey(nums1[i])){
                map.put(nums1[i],1);
            }else{
                int count = map.get(nums1[i]);
                map.put(nums1[i], ++count);
            }
        }
        
        for(int i = 0; i < nums2.length; i++){
            if(map.containsKey(nums2[i])){
                int count = map.get(nums2[i]);
                if(count > 0){
                    map.put(nums2[i],--count);
                    list.add(nums2[i]);
                }
            }
        }
        
        int[] res = new int[list.size()];
        int count = 0;
        for(Integer i : list){
            res[count++] = i;
        }
        
        return res;
    }
}

//2. Sort the two arrays first, and use two pointers to traverse them.

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int p1 = 0, p2 = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> list = new ArrayList<>();
        while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] == nums2[p2]){
                list.add(nums1[p1]);
                p1++;
                p2++;
            } 
            else if(nums1[p1] < nums2[p2]){
                p1++;
            }
            else if(nums1[p1] > nums2[p2]){
                p2++;
            }
        }
        int[] res = new int[list.size()];
        int count = 0;
        for(Integer i : list){
            res[count++] = i;
        }
        return res;
        
    }
}
      
