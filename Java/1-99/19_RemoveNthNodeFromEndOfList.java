// Given a linked list, remove the nth node from the end of list and return its head.

// For example,

//    Given linked list: 1->2->3->4->5, and n = 2.

//    After removing the second node from the end, the linked list becomes 1->2->3->5.
// Note:
// Given n will always be valid.
// Try to do this in one pass.

// Solution: Two pointers.

//Use a fast pointer and a slow pointer, the distance between the two pointers is n.
// fast = slow + n.
// if fast == null, slow.next = slow.next.next.
// if n == length of the list, remove the head.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head, p2 = head;
        for(int i = 0; i < n; i++){
            p2 = p2.next;
        }
        if(p2 == null) return head.next;
        while(p2.next != null){
            p2 = p2.next;
            p1 = p1.next;
        }
        p1.next = p1.next.next;
        return head;
    }
}