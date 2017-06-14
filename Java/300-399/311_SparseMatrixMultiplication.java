// Given two sparse matrices A and B, return the result of AB.

// You may assume that A's column number is equal to B's row number.

// Example:

// A = [
//   [ 1, 0, 0],
//   [-1, 0, 3]
// ]

// B = [
//   [ 7, 0, 0 ],
//   [ 0, 0, 0 ],
//   [ 0, 0, 1 ]
// ]


//      |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
// AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
//                   | 0 0 1 |

// Solution:

// Normal Matrix Multiplication: 
// for(int i = 0; i < m; i ++)
// 		for(int j = 0; j < n; j++)
// 			for(int k = 0; k < ab; k++)
// 				C[i][j] += A[i][k] + B[k][j];


// This is equal to 

// for(int i = 0; i < m; i ++)
// 		for(int k = 0; k < ab; k++)
// 			for(int j = 0; j < n; j++)
// 				C[i][j] += A[i][k] + B[k][j];

// Because the elements in a sparse matrix are alomost all 0.
// So we can simply skip the 0 ones.
// for(int i = 0; i < m; i ++)
// 		for(int k = 0; k < ab; k++)
// 			if(A[i][k] != 0)
// 			for(int j = 0; j < n; j++)
// 				if(B[k][j] != 0)
// 				C[i][j] += A[i][k] + B[k][j];

// Related CMU Lecture: http://www.cs.cmu.edu/~scandal/cacm/node9.html


public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = B[0].length;
        int ab = A[0].length;
        int[][] result = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int k = 0; k < ab; k++){
                if(A[i][k] != 0){
                    for(int j = 0; j < n; j++){
                        if(B[k][j] != 0) result[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return result;
    }
}