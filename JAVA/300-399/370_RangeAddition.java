// Assume you have an array of length n initialized with all 0's and are given k update operations.

// Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.

// Return the modified array after all k operations were executed.

// Example:

// Given:

//     length = 5,
//     updates = [
//         [1,  3,  2],
//         [2,  4,  3],
//         [0,  2, -2]
//     ]

// Output:

//     [-2, 0, 3, 5, 3]
// Explanation:

// Initial state:
// [ 0, 0, 0, 0, 0 ]

// After applying operation [1, 3, 2]:
// [ 0, 2, 2, 2, 0 ]

// After applying operation [2, 4, 3]:
// [ 0, 2, 5, 5, 3 ]

// After applying operation [0, 2, -2]:
// [-2, 0, 3, 5, 3 ]

// Hint:

// Thinking of using advanced data structures? You are thinking it too complicated.
// For each update operation, do you really need to update all elements between i and j?
// Update only the first and end element is sufficient.
// The optimal time complexity is O(k + n) and uses O(1) extra space.


// Solution:
// For example:
// Input : [1,3,2] and length = 5.
// And we only update 1 with 2 and 4 (3 + 1) with -2  : [0,0,0,0,0] ==> [0,2,0,0,-2].
// Then, sum the array from left to right (array[i] += array[i - 1] : [0,2,2,2,0] is the final answer.

// The triplet [i,j,k] only update a[i:j] with k, so a[0:i - 1] and a[j + 1 : end] is not affected.
// Update a[i] += k, and let a[i + 1] += a[i], a[i + 2] += a[i + 1] ... a[j] += a[j - 1]. 
// Because a[j + 1] = -k, so the elements after a[j] will not affected by k.

public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        for(int i = 0; i < updates.length; i++){
            result[updates[i][0]] += updates[i][2];
            if(updates[i][1] + 1 < length) result[updates[i][1] + 1] += -updates[i][2]; 
        }
        for(int i = 1; i < length; i++){
            result[i] += result[i - 1];
        }
        return result;
    }
}