//Reverse a singly linked list.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode p = head;
        if(head == null) return head;
        if(head.next == null)return head;
        ListNode q = head.next;
        head.next = null;
        while(q.next != null){
            ListNode r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        q.next = p;
        return q;
    }
}
