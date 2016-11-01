// Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

// For example,
// Given [3,2,1,5,6,4] and k = 2, return 5.

// Note: 
// You may assume k is always valid, 1 ≤ k ≤ array's length.

// Solution 1 : Quicksort and find the k-th element
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

// Solution 2 : Heap Sort.
// Create a min heap, if heap.size() > k, heap.poll().

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int num : nums){
            heap.offer(num);
            if(heap.size() > k){
                heap.poll();
            }
        }
        return heap.peek();
    }
}

// Solution 3 : QuickSelect
// Find a number as a flag, if nums[i] < flag, move it to the left, else move it to the right.
// If index of flag == k, return nums[flag].
// If index of flag < k, find in the right.
// else, find in the left.
// Suffle is used to guarantee the O(n).

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0) return -1;
        shuffle(nums);
        return partition(nums,0,nums.length - 1, k - 1);
    }
    
    private int partition(int[] nums, int low, int high, int k){
        if(low > high) return -1;
        int pivot = nums[high], left = low;
        for(int i = low; i < high; i++){
            if(nums[i] >= pivot) swap(nums,i,left++);
        }
        swap(nums,left,high);
        if(left == k) return nums[left];
        else if(left < k) return partition(nums,left + 1, high,k);
        else return partition(nums,low,left - 1,k);
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void shuffle(int[] nums){
        Random random = new Random();
        for(int i = 0; i < nums.length; i++){
            swap(nums,i,random.nextInt(i + 1));
        }
    }
}
