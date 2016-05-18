// Given a sorted linked list, delete all duplicates such that each element appear only once.

// For example,
// Given 1->1->2, return 1->2.
// Given 1->1->2->3->3, return 1->2->3.

//Idea: Compare current node p to the next node q, if their values are equal, move q to the next. Do it recursively until 
//their values are not equal, then change p.next = q.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        if(head == null) return head;
        if(head.next == null) return head;
        ListNode q;
        while(p.next != null){
            q = p.next;
            while(p.val == q.val){
                q = q.next;
                if(q == null) break;
            }
            p.next = q;
            if(q != null){
                p = q;
            }
        }
        return head;
    }
}
