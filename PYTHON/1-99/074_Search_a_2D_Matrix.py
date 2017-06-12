#Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
#
#
#
#Integers in each row are sorted from left to right.
#The first integer of each row is greater than the last integer of the previous row.
#
#
#
#
#For example,
#
#Consider the following matrix:
#
#
#[
#  [1,   3,  5,  7],
#  [10, 11, 16, 20],
#  [23, 30, 34, 50]
#]
#
#
#Given target = 3, return true.
class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if len(matrix) == 0 : return False
        n,m = len(matrix),len(matrix[0])
        start,end = 0,n * m - 1
        while start <= end:
            mid = start + (end - start) / 2
            num = matrix[mid / m][mid % m]
            if num == target : return True
            elif num < target : start = mid + 1
            else : end = mid - 1
        return False