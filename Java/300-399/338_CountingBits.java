// Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

// Example:
// For num = 5 you should return [0,1,1,2,1,2].

// Follow up:

// It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
// Space complexity should be O(n).
// Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.

// Solution 1:
// 0 ->   0   A[0] = 0
// --------
// 1 ->   1   A[1] = 1
// --------
// 2 ->  10   A[2] = 1
// 3 ->  11   A[3] = 2
// --------
// 4 -> 100   A[4] = 1
// 5 -> 101   A[5] = 2
// 6 -> 110   A[6] = 2
// 7 -> 111   A[7] = 3

// As we can see, A[1] = A[1 - 1] + 1; --> 1 - 2^0

// 				  A[2] = A[2 - 2] + 1; --> 2 - 2^1
// 				  A[3] = A[3 - 2] + 1; --> 2 - 2^1

// 				  A[4] = A[4 - 4] + 1; --> 2 - 2^2
// 				  A[5] = A[5 - 4] + 1; ...
// 				  A[6] = A[6 - 4] + 1; ...
//                A[7] = A[7 - 4] + 1; ...

// That is because the difference between 0 and 1 is the most significant bit.
// The difference between 0 and 2 is the most significant bit, so are 1 and 3, 0 and 4, 1 and 5, 2 and 6, 3 and 7... and so on so forth.
// So first we set the offset to 2, when i < 2, A[i] = A[i - offset / 2] + 1. 
// And we update offset *= 2 each time when i >= offset.

public class Solution {
    public int[] countBits(int num) {
        int[] ret = new int[num + 1];
        ret[0] = 0;
        int offset = 2;
        for(int i = 1; i <= num;i++){
            if(i >= offset) offset *= 2;
            ret[i] = ret[i - offset / 2] + 1;
        }
        return ret;
    }
}

// Solution 2:
// However, a more simple solution is focusing on the least significant bit.
// 
// 0 ->   0   A[0] = 0
// --------
// 1 ->   1   A[1] = 1
// --------
// 2 ->  10   A[2] = 1
// 3 ->  11   A[3] = 2
// --------
// 4 -> 100   A[4] = 1
// 5 -> 101   A[5] = 2
// 6 -> 110   A[6] = 2
// 7 -> 111   A[7] = 3

// As we can see, '100' >> 1 ==> '10'  4 & 1 = 0. So, A[4] = A[4 >> 1] + 4 & 1.
// 				  '111' >> 1 ==> '11'  7 & 1 = 1. So, A[7] = A[7 >> 1] + 7 & 1.

public class Solution {
    public int[] countBits(int num) {
        int[] ret = new int[num + 1];
        ret[0] = 0;
        int offset = 2;
        for(int i = 1; i <= num;i++){
            ret[i] = ret[i >>> 1] + (i & 1);
        }
        return ret;
    }
}
















