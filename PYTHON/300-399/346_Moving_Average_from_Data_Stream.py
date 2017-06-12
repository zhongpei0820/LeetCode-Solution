#Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
#
#For example,
#
#MovingAverage m = new MovingAverage(3);
#m.next(1) = 1
#m.next(10) = (1 + 10) / 2
#m.next(3) = (1 + 10 + 3) / 3
#m.next(5) = (10 + 3 + 5) / 3
#
#
from collections import deque
class MovingAverage(object):

    def __init__(self, size):
        """
        Initialize your data structure here.
        :type size: int
        """
        self.queue = deque([])
        self.size = size
        self.currSum = 0
        self.currSize = 0

    def next(self, val):
        """
        :type val: int
        :rtype: float
        """
        if self.currSize == self.size:
            self.currSum -= self.queue.popleft()
            self.currSize -= 1
        self.queue.append(val)
        self.currSum += val
        self.currSize += 1
        return float(self.currSum) / self.currSize


# Your MovingAverage object will be instantiated and called as such:
# obj = MovingAverage(size)
# param_1 = obj.next(val)