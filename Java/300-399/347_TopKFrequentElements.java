// Given a non-empty array of integers, return the k most frequent elements.

// For example,
// Given [1,1,1,2,2,3] and k = 2, return [1,2].

// Note: 
// You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
// Your algorithm's time complexity must be better than O(n log n), where n is the array's size.



// Solution : HashMap and Heap
// Iterate the array, put <nums[i], number of nums[i]> into map,
// Use heap to sort the map according to the value.
// Poll the first k elements out of the heap.

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<Map.Entry<Integer,Integer>>((a,b) -> (b.getValue() - a.getValue()));
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            heap.add(entry);
        }
        for(int i = 0; i < k; i++){
            res.add(heap.poll().getKey());
        }
        return res;
    }
}


// Solution 2 : Bucket sort.
// Use an array to store the elements that appears i times at a[i].
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for(int key : map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null) bucket[freq] = new LinkedList();
            bucket[freq].add(key);
        }
        List<Integer> res = new LinkedList<>();
        for(int i = bucket.length - 1; i > 0 && k > 0; i--){
            if(bucket[i] != null){
                res.addAll(bucket[i]);
                k -= bucket[i].size();
            }
        }
        return res;
    }
}