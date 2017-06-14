#
#Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
#

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        p = head = ListNode(0)
        h = [(l.val,l) for l in lists if l]
        heapq.heapify(h)
        while len(h) > 0:
            val,tail = h[0]
            p.next = tail
            p = p.next
            if tail.next != None : heapq.heapreplace(h,(tail.next.val,tail.next))
            else: heapq.heappop(h)
        return head.next