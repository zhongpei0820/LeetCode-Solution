#Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
#
#
#
#For example,
#Given the following matrix:
#
#
#[
# [ 1, 2, 3 ],
# [ 4, 5, 6 ],
# [ 7, 8, 9 ]
#]
#
#
#You should return [1,2,3,6,9,8,7,4,5].
#

class Solution(object):
    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        n = len(matrix)
        if n == 0 : return matrix
        m = len(matrix[0])
        ret = []
        colStart,colEnd,rowStart,rowEnd = 0,m - 1,0,n - 1
        while colStart < colEnd and rowStart < rowEnd:
            i,j = rowStart,colStart
            for j in range(colStart,colEnd):
                ret.append(matrix[i][j])
            colStart += 1
            j += 1
            for i in range(rowStart,rowEnd):
                ret.append(matrix[i][j])
            rowStart += 1
            i += 1
            for j in range(colEnd,colStart - 1,-1):
                ret.append(matrix[i][j])
            colEnd -= 1
            j -= 1
            for i in range(rowEnd,rowStart - 1,-1):
                ret.append(matrix[i][j])
            rowEnd -= 1
            i += 1
        if colStart == colEnd and rowStart == rowEnd:ret.append(matrix[colStart][rowStart])
        elif colStart == colEnd: 
            for i in range(rowStart,rowEnd + 1): 
                ret.append(matrix[i][colEnd])
        elif rowStart == rowEnd:
            for i in range(colStart,colEnd + 1):
                ret.append(matrix[rowStart][i])
        return ret