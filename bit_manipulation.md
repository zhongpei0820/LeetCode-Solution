# Bit Manipulation
##136. Single Number 
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Solution: XOR

Normal:

```python
class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ret = 0
        for i in nums:
            ret ^= i
        return ret
```
One line:
```python
class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        return reduce(operator.xor,nums)
```


---


##137. Single Number II   
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Solution : 

For example: nums = [1,1,1,2,2,2,3]
Binary representation of nums:
```
[ 
  [0,0,1]
  [0,0,1]
  [0,0,1]
  [0,1,0]
  [0,1,0]
  [0,1,0]
  [0,1,1]
 ]
 ```
 Number of 1s in each column is [0,4,4].
 So, the single number is [0 % 3, 4 % 3, 4 % 3] = [0, 1, 1] = 3.
 
The idea is that, if all of these elements appear three times, the number of 1s in each column must be a multiplier of 3. 

Now, one of them only appears once rather than three times. We can do a mod operation on the number of 1s in each column. If the remaining is not 0, it means the single number has that bit as 1. 

And we can find the binary representation of the single number by doing mod for all 32-bit (Integer). Then, convert binary to integer.

Now that we have the idea, the first step is counting number of 1s in each column. This can be achieved by a '&' operator. 

```python
for i in range(0,32):
    for num in nums:
      if num & 1 << i == 0 : counter += 1
```

Then, we can do a mod operation to find the binary representation of the single number. And convert it into integer.

```python
single |= (counter % 3) << i
```
 
 The complete python code:

```python
class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ret = 0
        for i in range(0,32):
            counter = 0
            for num in nums:
                if num & 1 << i : counter += 1
            ret |= (counter % 3) << i
        return ret if ret < 2 ** 31 else ret - 2 ** 32
```
