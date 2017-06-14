// Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

// Note:
// The number of people is less than 1,100.

// Example

// Input:
// [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

// Output:
// [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

// Solution:
// First we pick up the tallest people  in a sbuarray and sort them by the k.
// Then we pick up the tallest of the rest poeple and insert them into the kth position of subarray.

// First, we pick up [[7,0] , [7,1]], the rest are [[4,4],[5,0],[6,1],[5,2]].
// Then, pick [6,1] and insert it into the subarray : [[7,0] , [6,1], [7,1]].
// Then pick [5,0] and [5,2] ==> [[5,0], [7,0], [5,2] [6,1], [7,1]]. And so on so forth.

// It can be done equally by sort the oringial array first by the h and if they have the same k sort by k.

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        List<int[]> list = new LinkedList<>();
        for(int[] arr : people){
            list.add(arr[1],arr);
        }
        return list.toArray(new int[0][0]);
    }
}