// A group of two or more people wants to meet and minimize the total travel distance. 
// You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. 
// The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

// For example, given three people living at (0,0), (0,4), and (2,2):

// 1 - 0 - 0 - 0 - 1
// |   |   |   |   |
// 0 - 0 - 0 - 0 - 0
// |   |   |   |   |
// 0 - 0 - 1 - 0 - 0
// The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.

//Idea: First, we simplify this problem to 1D. 
//      How to find the meeting point that minimize the total distance in 1D array?
//      For example: 1-0-1-0-1. We note that the 3-rd point is the ideal meeting point, and the minimal distance is 2+0+2 = 4.
//      So, we guess that the median point is the ideal meeting point. Then we need to prove it.
//      For example, 1-1-0-0-1, the 2nd point is the median point of all 1s, and the distance is 4. 
//      If we use the 3rd point as the meeting point, the distance is gonna like this:
//      Because now we have two points in the left, so we add 2*(1) to the distance.
//      One point on the left, so we substract 1*(1) to the distance, the total distance now is 4 + 2*1 - 1*1 = 5.
//      Let's generalize this prove to n nodes.
//      Assume the total distance using median point as the meeting point is d.
//      The number of nodes in the left = The number of nodes in the right.
//      If we move the meeting point to the left or to the right, the number of points in two sides will not be equal,
//      so the total distance is gonna be d + m, which must be greater than d.
//      So, the median point is the meeting point in 1D.
//      In 2D, we can calculate the total distance by adding the distance in x and distance in y.
//      The key point is to find the median point in x and y. 
//      Note that the median point means that the number of points at its left and right is the same.
//      For example: 
//      1 - 0 - 1 - 0 - 1       -> x: 2*1 - 1 - 1 - 0 - 1  
//      |   |   |   |   |
//      1 - 1 - 0 - 0 - 0
//      The median point in x is the second point, not the third, because there are two points on the left of the 2nd point.

public class Solution {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) col.add(i);
            }
        }
        
        for(int j = 0; j < n; j++){
            for(int i = 0; i < m; i++){
                if(grid[i][j] == 1) row.add(j);
            }
        }
        
        return minDistance1D(col) + minDistance1D(row);
        
    }
    
    private int minDistance1D(ArrayList<Integer> list){
        int mid = list.get(list.size()/2);
        int distance = 0;
        for(Integer i : list){
            distance += Math.abs(i - mid);
        }
        return distance;
    }
}
