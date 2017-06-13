#Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
#
#Example 1:
#11110110101100000000
#Answer: 1
#Example 2:
#11000110000010000011
#Answer: 3
#
#Credits:Special thanks to @mithmatt for adding this problem and creating all test cases.

class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        ret = 0
        if len(grid) == 0 or len(grid[0]) == 0 : return ret
        m,n = len(grid),len(grid[0])
        isVisited = [[0] * n for i in range(m)]
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1' and isVisited[i][j] == 0:
                    self.bfs(grid,isVisited,i,j)
                    ret += 1
        return ret
                    
    def bfs(self,grid,isVisited,startX,startY):
        m,n = len(grid),len(grid[0])
        isVisited[startX][startY] = 1
        q = collections.deque([(startX,startY)])
        while len(q) != 0:
            currX,currY = q.popleft()
            for x,y in ((currX - 1,currY),(currX + 1,currY),(currX,currY - 1),(currX,currY + 1)):
                if 0 <= x < m and 0 <= y < n and grid[x][y] == '1' and isVisited[x][y] == 0:
                    q.append((x,y))
                    isVisited[x][y] = 1
                    