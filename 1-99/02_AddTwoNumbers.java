
// You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8

//Solution: int carry to record the carry number.
//          if l1 and l2 have different length, use 0 to replace the value of the shorter one. 

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
        ListNode head = new ListNode((l1.val + l2.val) % 10);
        ListNode prev = head;
        int carry = l1.val + l2.val > 9 ? 1 : 0;
        l1 = l1 == null ? null : l1.next;
        l2 = l2 == null ? null : l2.next;
        while(l1 != null || l2 != null || carry != 0){
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            ListNode curr = new ListNode((val1 + val2 + carry) % 10);
            prev.next = curr;
            prev = curr;
            carry = val1 + val2 + carry > 9 ? 1 : 0;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return head;
    }
}