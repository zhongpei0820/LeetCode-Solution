#
#Given a 2D board and a word, find if the word exists in the grid.
#
#
#The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
#
#
#
#For example,
#Given board = 
#
#[
#  ['A','B','C','E'],
#  ['S','F','C','S'],
#  ['A','D','E','E']
#]
#
#
#word = "ABCCED", -> returns true,
#word = "SEE", -> returns true,
#word = "ABCB", -> returns false.
#
class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        n = len(board)
        if n == 0 : return False
        m = len(board[0])
        isVisited = [[0] * m for i in range(0,n)]
        for i in range(0, n):
            for j in range(0, m):
                if board[i][j] == word[0]:
                    if self.dfs(board, isVisited, word, 0, i, j): return True
        return False
        
    def dfs(self, board, isVisited, word, index, x, y):
        isVisited[x][y] = 1
        if index == len(word) - 1: return True
        next = word[index + 1]
        # print word[index], next, isVisited
        left,right,up,down = False, False, False, False
        #moving left
        if y > 0 and isVisited[x][y - 1] == 0 and board[x][y - 1] == next: 
            if self.dfs(board, isVisited, word, index + 1, x, y - 1): return True
        #moving right
        if y < len(board[0]) - 1 and isVisited[x][y + 1] == 0 and board[x][y + 1] == next:
            if self.dfs(board, isVisited, word, index + 1, x, y + 1): return True
        #moving up
        if x > 0 and isVisited[x - 1][y] == 0 and board[x - 1][y] == next:
            if self.dfs(board, isVisited, word, index + 1, x - 1, y): return True
        #moving down
        if x < len(board) - 1 and isVisited[x + 1][y] == 0 and board[x + 1][y] == next:
            if self.dfs(board, isVisited, word, index + 1, x + 1, y): return True
        isVisited[x][y] = 0
        return False