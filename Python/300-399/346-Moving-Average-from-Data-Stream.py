# Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

# For example,
# MovingAverage m = new MovingAverage(3);
# m.next(1) = 1
# m.next(10) = (1 + 10) / 2
# m.next(3) = (1 + 10 + 3) / 3
# m.next(5) = (10 + 3 + 5) / 3

# Solution

from collections import deque 
class MovingAverage(object):

    def __init__(self, size):
        """
        Initialize your data structure here.
        :type size: int
        """
        self.q = deque()
        self.sum = 0
        self.size = size

    def next(self, val):
        """
        :type val: int
        :rtype: float
        """
        if len(self.q) < self.size : 
            self.sum += val
            self.q.append(val)
        else:
            self.sum += val - self.q.popleft()
            self.q.append(val)
        return float(self.sum) / len(self.q)
        
        


# Your MovingAverage object will be instantiated and called as such:
# obj = MovingAverage(size)
# param_1 = obj.next(val)