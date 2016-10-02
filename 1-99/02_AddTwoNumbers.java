// You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p,head;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        int val = l1.val + l2.val;
        head = new ListNode(val % 10);
        p = head;
        int carry = val > 9 ? 1 : 0;
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null || l2 != null){
            if(l1 == null){
                while(l2 != null){
                    ListNode node = new ListNode((l2.val + carry) % 10);
                    carry = (l2.val + carry) > 9 ? 1 : 0;
                    p.next = node;
                    p = node;
                    l2 = l2.next;
                }
                break;
            } 
            if(l2 == null){ 
                while(l1 != null){
                    ListNode node = new ListNode((l1.val + carry) % 10);
                    carry = (l1.val + carry) > 9 ? 1 : 0;
                    p.next = node;
                    p = node;
                    l1 = l1.next;
                }
                break;
            } 
            val = l1.val + l2.val + carry;
            ListNode node = new ListNode(val % 10);
            p.next = node;
            p = node;
            carry = val > 9 ? 1 : 0;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(carry != 0){
            ListNode node = new ListNode(carry);
            p.next = node;
        }
        return head;
    }
}