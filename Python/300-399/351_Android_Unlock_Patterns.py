#
#Given an Android 3x3 key lock screen and two integers m and n, where  1 ≤ m ≤ n ≤ 9, count the total number of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.Rules for a valid pattern:
#Explanation:
#
#| 1 | 2 | 3 |
#| 4 | 5 | 6 |
#| 7 | 8 | 9 |
#Invalid move: 4 - 1 - 3 - 6 
#
#Line  1 - 3 passes through key 2 which had not been selected in the pattern.Invalid move: 4 - 1 - 9 - 2
#
#Line  1 - 9 passes through key 5 which had not been selected in the pattern.Valid move: 2 - 4 - 1 - 3 - 6
#
#Line 1 - 3 is valid because it passes through key 2, which had been selected in the patternValid move: 6 - 5 - 4 - 1 - 9 - 2
#
#Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.Example:
#Given m = 1, n = 1, return 9.
#Credits:Special thanks to @elmirap for adding this problem and creating all test cases.

class Solution(object):
    def numberOfPatterns(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        ret = 0
        skip = [[0 for i in xrange(10)] for i in xrange(10)]
        visit = [0 for i in xrange(10)]
        skip[1][3] = skip[3][1] = 2
        skip[1][7] = skip[7][1] = 4
        skip[3][9] = skip[9][3] = 6
        skip[1][9] = skip[9][1] = skip[3][7] = skip[7][3] = skip[2][8] = skip[8][2] = skip[4][6] = skip[6][4] = 5
        skip[7][9] = skip[9][7] = 8
        for i in range(m,n + 1):
            ret += 4 * self.backTracking(visit,skip,1,i - 1)
            ret += 4 * self.backTracking(visit,skip,2,i - 1)
            ret += self.backTracking(visit,skip,5,i - 1)
        return ret
    
        
    def backTracking(self,visit,skip,curr,remain):
        if remain == 0 : return 1
        if remain < 0 : return 0
        ret = 0
        visit[curr] = 1
        for i in range(1,10):
            if (not visit[i]) and (skip[curr][i] == 0 or visit[skip[curr][i]]):
                ret += self.backTracking(visit,skip,i,remain - 1)
        visit[curr] = 0
        return ret
