#Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
#
#
#
#The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
#
#
#Example:
#
#Given matrix = [
#  [3, 0, 1, 4, 2],
#  [5, 6, 3, 2, 1],
#  [1, 2, 0, 1, 5],
#  [4, 1, 0, 1, 7],
#  [1, 0, 3, 0, 5]
#]
#
#sumRegion(2, 1, 4, 3) -> 8
#update(3, 2, 2)
#sumRegion(2, 1, 4, 3) -> 10
#
#
#
#Note:
#
#The matrix is only modifiable by the update function.
#You may assume the number of calls to update and sumRegion function is distributed evenly.
#You may assume that row1 &le; row2 and col1 &le; col2.
#
#

class NumMatrix(object):
    def __init__(self, matrix):
        """
        initialize your data structure here.
        :type matrix: List[List[int]]
        """
        if len(matrix) == 0 : return
        self.n = len(matrix)
        self.m = len(matrix[0])
        self.nums = [[0 for i in range(0,self.m)] for j in range(0,self.n)]
        self.sum = [[0 for i in range(0,self.m + 1)] for j in range(0,self.n + 1)]
        for i in range(0,self.n):
            for j in range(0,self.m):
                self.update(i,j,matrix[i][j])

    def update(self, row, col, val):
        """
        update the element at matrix[row,col] to val.
        :type row: int
        :type col: int
        :type val: int
        :rtype: void
        """
        diff = val - self.nums[row][col]
        self.nums[row][col] = val
        i = row + 1
        while i < self.n + 1:
            j = col + 1
            while j < self.m + 1:
                self.sum[i][j] += diff
                j += j & -j
            i += i & -i
        

    def sumRegion(self, row1, col1, row2, col2):
        """
        sum of elements matrix[(row1,col1)..(row2,col2)], inclusive.
        :type row1: int
        :type col1: int
        :type row2: int
        :type col2: int
        :rtype: int
        """
        return self.getSum(row2,col2) - self.getSum(row2,col1 - 1) - self.getSum(row1 - 1,col2) + self.getSum(row1 - 1, col1 - 1)
        
    def getSum(self, row, col):
        sum = 0
        i = row + 1
        while i > 0:
            j = col + 1
            while j > 0:
                sum += self.sum[i][j]
                j -= j & -j
            i -= i & -i
        return sum
        

# Your NumMatrix object will be instantiated and called as such:
# numMatrix = NumMatrix(matrix)
# numMatrix.sumRegion(0, 1, 2, 3)
# numMatrix.update(1, 1, 10)
# numMatrix.sumRegion(1, 2, 3, 4)