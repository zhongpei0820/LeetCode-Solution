//The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.Given an integer n, return all distinct solutions to the n-queens puzzle.Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.For example,
//There exist two distinct solutions to the 4-queens puzzle:[
// [".Q..",  // Solution 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // Solution 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            dfs(0,i,n,a,res);
        }
        return res;
    }
    
    private void dfs(int row,int col, int n, int[] a, List<List<String>> res){
        a[row] = col;
        if(row == n - 1){
            res.add(print(a,n));
            return;
        } 
        for(int i = 0; i < n; i++){
            if(isValid(row+1,i,a)){
                dfs(row+1,i,n,a,res);
            }
        }
    }
    
    private boolean isValid(int row,int col,int[] a){
        for(int i = 0; i < row; i++){
            if(a[i] == col) return false;
            if(Math.abs(row - i) == Math.abs(col - a[i])) return false;
        }
        return true;
    }
    
    private List<String> print(int[] a, int n){
        List<String> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            char[] temp = new char[n];
            for(int j = 0; j < n; j++){
                if(a[i] == j) temp[j] = 'Q';
                else temp[j] = '.';
            }
            res.add(new String(temp));
        }
        return res;
    }
    
}
