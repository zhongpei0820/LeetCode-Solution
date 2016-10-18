// There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different.
// You have to paint all the houses such that no two adjacent houses have the same color.

// The cost of painting each house with a certain color is represented by a n x 3 cost matrix. 
// For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... 
// Find the minimum cost to paint all houses.

//Idea: Dynamic Programming. Let res[i][j] donates the minimum costs painting i houses and the i-th house is painted with j-th color.
//                           res[i][j] = min{res[i - 1][k] for all k != j },because i cannot have the same color with i - 1
//                           result = min{res[n][k] for all k < n}

public class Solution {
    public int minCost(int[][] costs) {
        if(costs.length == 0) return 0;
        int m = costs.length, n = costs[0].length;
        int[][] res = new int[m][n];
        for(int i = 0; i < n; i++){
            res[0][i] = costs[0][i];
        }
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                int min = Integer.MAX_VALUE;
                for(int k = 0; k < n; k++){
                    if(k != j) min = Math.min(min,res[i-1][k]);
                }
                res[i][j] = costs[i][j] + min;
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            result = Math.min(result,res[m - 1][i]);
        }
        return result;
    }
}

// A better version for this problem, since there are only three colors.

public class Solution {
    public int minCost(int[][] costs) {
        if(costs.length == 0) return 0;
        int m = costs.length;
        int currRed = costs[0][0];
        int currBlue = costs[0][1];
        int currGreen = costs[0][2];
        
        for(int i = 1; i < m; i++){
            int lastRed = currRed;
            int lastBlue = currBlue;
            int lastGreen = currGreen;
            currRed = Math.min(lastBlue,lastGreen) + costs[i][0];
            currBlue = Math.min(lastRed,lastGreen) + costs[i][1];
            currGreen = Math.min(lastRed,lastBlue) + costs[i][2];
        }
        return Math.min(currRed,Math.min(currBlue,currGreen));
    }
}