// Given a non-negative number represented as a singly linked list of digits, plus one to the number.

// The digits are stored such that the most significant digit is at the head of the list.

// Example:
// Input:
// 1->2->3

// Output:
// 1->2->4

// Solution: 
// This problem can be done by reverse, add and reverse.
// However there is a more simple solution
// Carry only exists if the last digit is 9.
// For example : 1 2 3 + 1 = 1 2 4.
// 				 1 2 9 + 1 = 1 3 0.
// So, if the last digit is not 9, the only thing we have to do is add 1 to the last digit.
// If the last digit is 9, we need to consider a carry.
// For example : 1 2 9 + 1 = 1 3 0.
// 				 1 9 9 + 1 = 2 0 0.
// So, the carry contunes to the last digit that is not 9.
// The solution now become clear:
// Find the first digit that is not 9 from right to left, let it be i.
// if i is the last node, simply add 1 and return.
// If not, add 1, set i + 1 to the last node to 0.
// If head > 9 ( 9 9 9 + 1 = 10 0 0), newHead = 1, head = head - 10, newHead.next = head.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode notNine = newHead;
        ListNode pointer = newHead;
        while(pointer != null){
            if(pointer.val != 9) notNine = pointer;
            pointer = pointer.next;
        }
        notNine.val += 1;
        notNine = notNine.next;
        while(notNine != null){
            notNine.val = 0;
            notNine = notNine.next;
        }
        return newHead.val == 0 ? head : newHead;
    }
}