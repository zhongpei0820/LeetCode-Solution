// Given a singly linked list, determine if it is a palindrome.

// Follow up:
// Could you do it in O(n) time and O(1) space?

//First Solution: Use two pointers to find the mid node, and reverse the second half of the list. Then compare the second half
//with the first half.

//For example: a -> b -> c -> b -> a. Use two pointers: slow and fast to traverse this list to find the mid.
//The speed of fast ot 2x than slow, e.g. slow = slow.next. fast = fast.next.next.
//If the list contains odd nodes, fast.next == null. If the list contains even odds, fast.next.next == null.
//Either way, the slow.next will be the mid.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow = slow.next;
        slow = reverseLinkedList(slow);
        fast = head;
        
        while(fast != slow && slow != null){
            if(fast.val != slow.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    
    private ListNode reverseLinkedList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode prev,curr,next;
        prev = next = null;
        curr = head;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;   
    }
}


//The second solution is reversing the first half of the list while traversing the list to find the mid.
//In this case, we only have to go thourgh this list once.
//If the list contains odd nodes: a -> b -> c -> b-> a ==> a <- b c(slow) -> b -> a(fast).
//If the list contains even nodes: a -> b -> c -> c -> b-> a ==> a <- b <- c(slow) c -> b -> a fast=null.
//So, if odd(fast != null), slow = slow.next.
//Then we compare the reversed first half with the second half.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        ListNode prev,next;
        prev = next = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        if(fast != null) slow = slow.next;
        
        while(slow != null){
            if(prev.val != slow.val) return false;
            slow = slow.next;
            prev = prev.next;
        }
        return true;
    }
}



