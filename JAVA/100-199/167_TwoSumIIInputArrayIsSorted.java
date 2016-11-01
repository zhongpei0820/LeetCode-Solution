// Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

// The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

// You may assume that each input would have exactly one solution.

// Input: numbers={2, 7, 11, 15}, target=9
// Output: index1=1, index2=2

//Idea: Binary Search for target - nums[i]. If found, return two indexes. If not, return null. The total time complexity, O(nlogn)

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for(int i = 0; i < numbers.length; i++){
            int temp = binarySearch(i + 1,numbers.length - 1,target - numbers[i],numbers);
            if(temp != -1){
                res[0] = i + 1;
                res[1] = temp + 1;
                return res;
            }
        }
        return res;
    }
    private int binarySearch(int low, int high, int target, int[] array){
        if(low > high) return -1;
        int mid = low + (high - low) / 2;
        if(array[mid] == target) return mid;
        if(array[mid] > target) return binarySearch(low, mid - 1, target, array);
        return binarySearch(mid + 1, high, target, array);
    }
}


// Solution 2: 
// Because numbers are sorted, use two pointers to traverse the array.
// i = 0, j = numbers.length - 1
// numbers[i] + numbers[j] < target, i++
// numbers[i] + numbers[j] > target, j--
// numbers[i] + numbers[j] == target, return.

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int i = 0, j = numbers.length - 1;
        while(i < j){
            int key = numbers[i] + numbers[j];
            if(key < target){
                i++;
            }else if(key > target){
                j--;
            }else{
                res[0] = i + 1;
                res[1] = j + 1;
                return res;
            }
        }
        return res;
    }
}

