#You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
#
#You may assume the two numbers do not contain any leading zero, except the number 0 itself.
#
#
#Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
#Output: 7 -> 0 -> 8

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        curr = dummy = ListNode(0)
        carry = 0
        while l1 != None or l2 != None or carry != 0:
            l = l1.val if l1 else 0
            r = l2.val if l2 else 0
            curr_sum = (l + r + carry) % 10
            carry = (l + r + carry) / 10
            curr.next = ListNode(curr_sum)
            curr = curr.next
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
        return dummy.next
        
        