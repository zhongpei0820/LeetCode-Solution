// There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

// The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

// Note:
// All costs are positive integers.

// Follow up:
// Could you solve it in O(nk) runtime?

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
	}


//A more simple solution : 
// Only have to store the smallest two costs in last painting.
// Since no same colors for adjacent houses, just select 2nd min cost color for i.

	public class Solution {
    public int minCostII(int[][] costs) {
        if(costs.length == 0) return 0;
        int m = costs.length, n = costs[0].length;
        int min1 = 0, min2 = 0, idMin1 = -1;
        for(int i = 0; i < m; i++){
            int last1 = min1, last2 = min2, lastMinId = idMin1;
            min1 = Integer.MAX_VALUE;
            min2 = Integer.MAX_VALUE;
            for(int j = 0; j < n; j++){
                int cost = costs[i][j] + (j == lastMinId ?  + last2 : last1);
                if(cost < min1){
                    min2 = min1;
                    min1 = cost;
                    idMin1 = j;
                }else if(cost < min2){
                    min2 = cost;
                }
            }
        }
        return min1;
    }
}