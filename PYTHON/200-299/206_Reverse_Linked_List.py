#Reverse a singly linked list.
#
#click to show more hints.
#
#Hint:
#A linked list can be reversed either iteratively or recursively. Could you implement both?
#
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head == None: return []
        list = []
        node = head
        while node != None:
            list.append(node.val)
            node = node.next
        node = head
        # print list
        for i in list[::-1]:
            node.val = i
            node = node.next
        return head
            