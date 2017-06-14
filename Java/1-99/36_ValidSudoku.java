// Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

// The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


// A partially filled sudoku which is valid.


//Idea: Three hash sets: one for row, one for column and one for bracket.

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> bkt = new HashSet<>();
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.' && !row.add(board[i][j])) return false;
                if(board[j][i] != '.' && !col.add(board[j][i])) return false;
                int x = (i % 3) * 3 + j / 3;
                int y = (i / 3) * 3 + j % 3;
                if(board[x][y] != '.' && !bkt.add(board[x][y])) return false;
            }
        }
        return true;
    }
}
