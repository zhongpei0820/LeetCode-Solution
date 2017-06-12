#You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
#
#Each 0 marks an empty land which you can pass by freely.
#Each 1 marks a building which you cannot pass through.
#Each 2 marks an obstacle which you cannot pass through.
#
#
#For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):
#
#1 - 0 - 2 - 0 - 1
#|   |   |   |   |
#0 - 0 - 0 - 0 - 0
#|   |   |   |   |
#0 - 0 - 1 - 0 - 0
#
#The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.
#
#Note:
#There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
import sys
import collections
class Solution(object):
    def shortestDistance(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if (len(grid) == 0 or len(grid[0]) == 0):  return -1
        m, n = len(grid), len(grid[0])
        dist,hit = [[0] * n for i in range(0, m)],[[0] * n for i in range(0, m)]
        buildings,blanks = 0,0
        for i in range(0, m):
            buildings += grid[i].count(1)
            blanks += grid[i].count(0)
        if buildings == 0 or blanks == 0: return -1
        for i in range(0, m):
            for j in range(0, n):
                if grid[i][j] == 1:
                    if not self.bfs(grid, dist,hit, buildings, i, j) : return -1
        minDistance = sys.maxint
        for i in range(0, m):
            for j in range(0, n):
                if grid[i][j] == 0 and hit[i][j] == buildings:
                    minDistance = min(minDistance, dist[i][j])
        return minDistance if minDistance != sys.maxint else -1

    def bfs(self, grid, dist, hit, buildings, x, y):
        m, n = len(grid), len(grid[0])
        level,visited = 0,1
        q = collections.deque()
        isVisited = [[0] * n for i in range(0, m)]
        q.append((x, y))
        isVisited[x][y] = 1
        while len(q) != 0:
            size = len(q)
            for i in range(0, size):
                curr = q.popleft()
                currX,currY = curr[0],curr[1]
                dist[currX][currY] += level
                for x,y in ((currX + 1,currY),(currX - 1,currY),(currX, currY + 1),(currX, currY - 1)):
                    if 0 <= x < m and 0 <= y < n and isVisited[x][y] == 0:
                        if grid[x][y] == 0:
                            q.append((x,y))
                            hit[x][y] += 1
                        if grid[x][y] == 1:
                            visited += 1
                        isVisited[x][y] = 1
            level += 1
        return visited == buildings