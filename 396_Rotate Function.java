// Given an array of integers A and let n to be its length.

// Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:

// F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].

// Calculate the maximum value of F(0), F(1), ..., F(n-1).

// Note:
// n is guaranteed to be less than 105.

// Example:

// A = [4, 3, 2, 6]

// F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
// F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
// F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
// F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26

// So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.

//Solution 1: A brute way.

//As we observed, F(0) =       0 * A[0] + 1 * A[1] + 2 * A[2] + 3 * A[3] + ... + (n - 1) * A[n - 1].
// 				  F(1) = (n - 1) * A[0] + 0 * A[1] + 1 * A[2] + 2 * A[3] + ... + (n - 2) * A[n - 1].
// So, we can see this as F(0) = A[0]*B[0] + A[1] * B[1] + .. + A[n] * B[n], where B = {0,1,2,3...,n-1}.
//And as n increases, B will be rotated 1 position clock-wise.

public class Solution {
    public int maxRotateFunction(int[] A) {
        if(A.length == 0) return 0;
        int[] B = new int[A.length];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++){
            B[i] = i;
        }
        for(int i = 0; i < A.length; i++){
            int tmp = 0;
            for(int j = 0; j < A.length; j++){
                tmp += A[j]*B[j];
            }
            max = Math.max(max,tmp);
            rotateArray(B);
        }
        return max;
    }
    
    private void rotateArray(int[] A){
        int tmp = A[0];
        for(int i = 0; i < A.length - 1; i++){
            A[i] = A[i+1];
        }
        A[A.length - 1] = tmp;
    }
}

//However. this solution cost O(n^2) time complexity.
//A more effcient way to solve this problem is by obsering that:
// F(0) =       0 * A[0] + 1 * A[1] + 2 * A[2] + 3 * A[3] + ... + (n - 1) * A[n - 1].
// F(1) = (n - 1) * A[0] + 0 * A[1] + 1 * A[2] + 2 * A[3] + ... + (n - 2) * A[n - 1].
//We can see that F(1) = F(0) - [A[0] + A[1] + A[2] + ... + A[n - 1]] + n * A[0].
//Similarly, 	  F(2) = F(1) - [A[0] + A[1] + A[2] + ... + A[n - 1]] + n * A[1].
//Therefore,      F(k) = F(k - 1) - Sum(A) + n * A[k - 1].
public class Solution {
    public int maxRotateFunction(int[] A) {
        int sum = 0;
        int max = 0;
        int F = 0;
        for(int i = 0; i < A.length; i++){
            sum += A[i];
            F += i*A[i];
        }
        max = F;
        for(int i = 1; i < A.length; i++){
            F = F - sum + A.length * A[i - 1];
            max = Math.max(F,max);
        }
        return max;
    }
}
