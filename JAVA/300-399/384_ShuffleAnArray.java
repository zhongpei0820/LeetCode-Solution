// Shuffle a set of numbers without duplicates.

// Example:

// // Init an array with set 1, 2, and 3.
// int[] nums = {1,2,3};
// Solution solution = new Solution(nums);

// // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
// solution.shuffle();

// // Resets the array back to its original configuration [1,2,3].
// solution.reset();

// // Returns the random shuffling of array [1,2,3].
// solution.shuffle();

// Solution:
// Use the random function to generate a random number representing the index in the orginal array.
// random(last), first time last = nums.length.
// shuffle[i] = num[random]
// Then move the last number in num to the index, last--.
// e.g. nums = [1,2,3,4,5]
// random(5) = 3.
// nums = [1,2,5,4,5]. Then random(4).


public class Solution {
    
    int[] nums;
    Random random;
    
    public Solution(int[] nums) {
        random = new Random();
        this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shuffle = new int[nums.length];
        int[] clone = nums.clone();
        int last = clone.length - 1;
        for(int i = 0; i < clone.length; i++){
            int index = random.nextInt(last + 1);
            shuffle[i] = clone[index];
            clone[index] = clone[last--];
        }
        return shuffle;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */


// Solution 2 : swap shuffle
public class Solution {
    
    int[] nums;
    Random random;
    
    public Solution(int[] nums) {
        random = new Random();
        this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shuffle = nums.clone();
        for(int i = 0; i < shuffle.length; i++){
            int index = random.nextInt(i + 1);
            swap(shuffle,i,index);
        }
        return shuffle;
    }
    
    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */