# Bit Manipulation
##Some Basic Tricks
###& Tricks
**Count number of 1**

```python
def CountNumberOfOne(num):
    count = 0
    while num :
        num &= (num - 1)
        count += 1
    return count
```

**Power of Two**
```python
def isPowerOfTwo(num):
    return num > 0 and not num & num - 1
```

**Power of Four**
```python
def isPowerOfFour(num):
        return num != 0 and not num & num - 1 and num & 0x55555555 != 0
```

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
---
##169. Majority Element
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

**Solution**:
This problem can be solved by sorting.
Here is a bit manipulation way to solve it:

If one element exist more than ⌊ n/2 ⌋ times, the bits in that number must appears more than ⌊ n/2 ⌋ times as well. 
For examle:
```
[1,1,1,2]
Binary:
0 1
0 1
0 1
1 0

In the first column, three 0, one 1
In the second colunm, three 1, one 0.
So the first digit should be 1, the second bit should be 0.
The answer is 0 1, which is 1.

```

Code:
```python
class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ret = 0
        for i in range(0,32):
            mask = 1 << i
            count = 0
            for num in nums:
                if num & mask : count += 1
            if count > len(nums) / 2 : ret |= mask
        return ret if ret < 2 ** 31 else ~ (ret ^ 0xFFFFFFFF)
```
---

##187. Repeated DNA Sequences
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
```
For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
```

**Solution**:
Although this problem can be solved by a simly hash table.
Let's try bit manipulation.
The key idea is that only 4 characters in DNA, can be represent in 2 bits : 00 01 10 11.
Thus, "AAAAACCCCC" can be represented by 0000000010101010, and we can put this as a key to the hashset.

Code:
```python
class Solution(object):
    def findRepeatedDnaSequences(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        dict = {'A' : 0, 'C' : 1, 'G' : 2, 'T' : 3}
        once = {}
        twice = {}
        ret = []
        for i in range(0,len(s) - 9):
            v = 0
            for c in s[i : i + 10]:
                v |= dict[c]
                v <<= 2
            if v in once and v not in twice:
                ret.append(s[i : i + 10])
                twice[v] = v
            else:
                once[v] = v
        return ret
```
---

##190. Reverse Bits
Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

**Solution**:

 For example: ABCDEFGH
 ```
 ABCDEFGH >> 4 = 0000ABCD
 ABCDEFGH << 4 = EFGH0000
 0000ABCD | EFGH0000 = EFGHABCD
 
 EFGHABCD & 00110011 = 00GH00CD
 EFGHABCD & 11001100 = EF00AB00
 00GH00CD << 2 = GH00CD00
 EF00AB00 >> 2 = 00EF00AB
 GH00CD00 & 00EF00AB = GHEFCDAB
 
 GHEFCDAB & 01010101 = 0H0F0D0B
 GHEFCDAB & 10101010 = G0E0C0A0
 0H0F0D0B << 1 = H0F0D0B0
 G0E0C0A0 >> 1 = 0G0E0C0A
 H0F0D0B0 | 0G0E0C0A = HGFEDCBA
 Reversed!
 ```

Code:
```python
class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        n = (n >> 16) | (n << 16)
        n = ((n & 0xFF00FF00) >> 8) | ((n & 0x00FF00FF) << 8)
        n = ((n & 0xF0F0F0F0) >> 4) | ((n & 0x0F0F0F0F) << 4)
        n = ((n & 0xCCCCCCCC) >> 2) | ((n & 0x33333333) << 2)
        n = ((n & 0xAAAAAAAA) >> 1) | ((n & 0x55555555) << 1)
        return n
```


---
##191. Number of 1 Bits

Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.

**Solution**:
Counting number of 1 bits is a basic bit operation.

n & (n - 1) set the rightmost 1 to 0.

So, while n is not 0, doing n & (n - 1), and adding up the counter

Code: 
```python
class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        ret = 0
        while n:
            n &= n - 1
            ret += 1
        return ret
```
---

##231. Power of Two
Given an integer, write a function to determine if it is a power of two.

**Solution** : 
n & (n - 1) sets the rightmost 1 to 0.
Any number is power of 4 any has only 1 in binary form.
If n & (n - 1) == 0, it is power of 2. Otherwise, it is not.
Except 0.

Code:
```python
class Solution(object):
    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        return n > 0 and not n & (n - 1)
```
---
##260. Single Number III
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

**Solution**: xor

This problem is similar to [136. Single Number](#136). Only this time there are two distinct single number. However, we can still solve this problem by using xor operator.

If we use xor to iterate nums in the given example, the result is 3 xor 5, which is 011 ^ 101 = 110.

Notice that 110 means 3 and 5 are different in the 2nd bit and 3rd bit. 

With the obeservation above, the idea is using a flag bit to divide the nums into two groups, one contains 3 and the other contains 5.

For example, we can use the either 2nd bit or 3rd bit as the flag to distinguish 3 from 5. Say the flag is 010. All nums & 010 == 0 will be classified into one group, the others will be put in the other group. Obviously, 5 will be in the first group, and 3 will be in the other.

Now that we have an idea to divide nums into two groups, the rest is simple: do xor on each of the groups, then we can find the unique one in each group.

The remaining problem is how to find the flag bit. After finding the xor of 3 and 5, which is 110. How to create the flag bit? 

The answer is using a simple bit operation : x & ~(x - 1).

First, x - 1 converts all bits from right to the rightmost 1 to 0.
```
x     : 1 0 0 0 1 0 ... 0 0 1 0 0 0
x - 1 : 1 0 0 0 1 0 ... 0 0 0 1 1 1
```
Then, ~(x - 1) flips all bits from the rightmost 1 to right.

```
x        : 1 0 0 0 1 0 ... 0 0 1 0 0 0
x - 1    : 1 0 0 0 1 0 ... 0 0 0 1 1 1
~(x - 1) : 0 1 1 1 0 1 ... 1 1 1 0 0 0
```
Finally, x & ~(x - 1) converts all bits to 0 excpet the rightmost 1.
```
x            : 1 0 0 0 1 0 ... 0 0 1 0 0 0
~(x - 1)     : 0 1 1 1 0 1 ... 1 1 1 0 0 0
x & ~(x - 1) : 0 0 0 0 0 0 ... 0 0 1 0 0 0
```
And this is the flag we need to divide the nums.

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
---
##268. Missing Number
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

**Solution**:xor
Code:
```python
class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ret = len(nums)
        for i in range(0,len(nums)):
            ret ^= nums[i] ^ i
        return ret
```


---


##371. Sum of Two Integers
Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.

**Solution**:
First we think how to do this in bit operation.
For example, a = 1, b = 2.
```
a = 0 1
b = 1 0
result = 1 1
```
We can notice that:
```
Two bits in the same position:
a b result
0 0   0
0 1   1
1 0   1
1 1   0
```
So we can use xor to do the calculation.
Also, we have to calculate the carry, because if two bits are 1, a carry is needed to be addded.
```
Two bits in the same position:
a b carry
0 0   0
0 1   0
1 0   0
1 1   1
```
So, we can use and to calculate the carry.
And carry = (a & b) << 1. Shifted by 1 because the carry should be added to left bit.
So, while carry != 0, we do the calculation of currSum + carry.


Code:

Recursive:
```python
class Solution(object):
    def getSum(self, a, b):
        """
        :type a: int
        :type b: int
        :rtype: int
        """
        mask = 0xFFFFFFFF #python use 64bit integer, convert it to 32bit
        sum = (a ^ b) & mask
        carry = ((a & b) << 1) & mask
        if carry : return self.getSum(sum,carry)
        return sum if sum < 2 ** 31 else ~ (sum ^ mask)
```

Iterative:
```python
class Solution(object):
    def getSum(self, a, b):
        """
        :type a: int
        :type b: int
        :rtype: int
        """
        mask = 0xFFFFFFFF #python use 64bit integer, convert it to 32bit
        while b != 0:
            a,b = (a^b) & mask, ((a & b) << 1) & mask
        return a if a < 2 ** 31 else ~ (a ^ mask)
        
```


---


##389. Find the Difference
Given two strings s and t which consist of only lowercase letters.

String t is generated by random shuffling string s and then add one more letter at a random position.

Find the letter that was added in t.

Example:
```
Input:
s = "abcd"
t = "abcde"

Output:
e

Explanation:
'e' is the letter that was added.
```

**Solution**: xor
This problem is similar to [136. Single Number](#136). 
Simply concatenating two strings, and using xor.

Code:
```python
class Solution(object):
    def findTheDifference(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        ret = 0
        for c in s + t:
            ret ^= ord(c)
        return chr(ret)   
```


---


        


