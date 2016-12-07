# Bit Manipulation
##136. Single Number{#136}
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

**Solution**: xor

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

**Solution** : 

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

##260. Single Number III
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

**Solution**: xor

This problem is similar to [136. Single Number](#136). Only this time there are two distinct single number. However, we can still solve this problem by using xor operator.

If we use xor to iterate nums in the given example, the result is 3 or 5, which is 011 ^ 101 = 110.

Notice that 110 means 3 and 5 are different in the 2nd bit and 3rd bit. 

With the obeservation above, the idea is using a flag bit to divide the nums into two groups, one contains 3 and the other contains 5.

For example, we can use the either 2nd bit or 3rd bit as the flag to distinguish 3 from 5. Say the flag is 010. All nums & 010 == 0 will be classified into one group, the others will be put in the other group. Obviously, 5 will be in the first group, and 3 will be in the other.

Now that we have an idea to divide nums into two group, the rest is simple: do xor to each of the two groups, we can find the unique one in each group.

The remaining problem is how to find the flag bit. After finding the xor of 3 and 5, which is 110. How to create the flag bit? Using a simple bit operation, x & ~(x - 1).

We know that x - 1 converts all 0 from right to the rightmost 1 to 1, and the rightmost 1 to 0. ~(x - 1) fliped all bits left of the rightmost 1. So x & ~(x - 1) converts all bit to 0 except the rightmost 1. And that is the flag we need.

Code:
```python
class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        ret = [0,0]
        xor = reduce(operator.xor,nums)
        xor &= ~(xor - 1)
        for num in nums:
            ret[num & xor == 0] ^= num
        return ret
        
```