// There is a fence with n posts, each post can be painted with one of the k colors.

// You have to paint all the posts such that no more than two adjacent fence posts have the same color.

// Return the total number of ways you can paint the fence.

// Note:
// n and k are non-negative integers.

//Idea: Let W[i] donates the total number of ways to paint i posts using k colors, 
//      There are two ways to paint the i-th post: 1. i has the same color with i - 1;
//                                                 2. i has the different color with i - 1;
//      Let S[i] donates the number of ways to paint i posts when i has the same color with i - 1;
//      Let D[i] donates the number of ways to paint i posts when i has the different color with i - 1;
//      W[i] = S[i] + D[i];
//      When i == 1; S[i] = 0 because there is no post before it, D[i] = k because it can be painted with any of the k colors;
//      When i == n; S[i] = D[i - 1] because when i and i - 1 are the same, i - 1 must be different from its previous, and because i and i - 1 have the same color, the number of ways are the same;
//                   D[i] = W[i - 1]* (k - 1) because i can be painted with any of the k colors except the previous one's color.

public class Solution {
    public int numWays(int n, int k) {
        if(n == 0) return 0;
        int sameColor = 0;
        int diffColor = k;
        int total = sameColor + diffColor;
        for(int i = 1; i < n; i++){
            sameColor = diffColor;
            diffColor = total*(k-1);
            total = sameColor + diffColor;
        }
        return total;
    }
}
