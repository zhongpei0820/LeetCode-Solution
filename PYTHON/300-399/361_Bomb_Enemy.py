#Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb. The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
# Note that you can only put the bomb at an empty cell. 
#
#Example:
#
#For the given grid
#
#0 E 0 0
#E 0 W E
#0 E 0 0
#
#return 3. (Placing a bomb at (1,1) kills 3 enemies)
#
#
#
#Credits:Special thanks to @memoryless for adding this problem and creating all test cases.
class Solution(object):
    def maxKilledEnemies(self, grid):

        if not grid: return 0
        if not grid[0]: return 0
        
        # collect row, col info O(m+n)
        row_cnt, col_cnt = len(grid), len(grid[0])
        self.grid = grid
        self.value = [[0]*col_cnt for _ in range(row_cnt)]
        
        # row direction scan, O(m*n)
        for i in range(row_cnt):
            # accumulate toward right
            cnt = 0
            for j in range(col_cnt):
                self.value[i][j] += cnt
                if grid[i][j] == 'E': cnt += 1
                if grid[i][j] == 'W': cnt = 0
            # accumulate toward right
            cnt = 0
            for j in reversed(range(col_cnt)):
                self.value[i][j] += cnt
                if grid[i][j] == 'E': cnt += 1
                if grid[i][j] == 'W': cnt = 0
                    
        # col direction scan, O(m*n)
        for j in reversed(range(col_cnt)):
            # accumulate toward right
            cnt = 0
            for i in range(row_cnt):
                self.value[i][j] += cnt
                if grid[i][j] == 'E': cnt += 1
                if grid[i][j] == 'W': cnt = 0
            # accumulate toward right
            cnt = 0
            for i in reversed(range(row_cnt)):
                self.value[i][j] += cnt
                if grid[i][j] == 'E': cnt += 1
                if grid[i][j] == 'W': cnt = 0
            
        # print(self.value)
        # only empty could be bump
        for i in range(row_cnt):
            for j in range(col_cnt):
                if grid[i][j] != '0':
                    self.value[i][j] = 0
        # print(self.value)
        
        return max([max(v) for v in self.value])