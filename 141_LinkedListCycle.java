// Given a linked list, determine if it has a cycle in it.

// Follow up:
// Can you solve it without using extra space?


//Idea: HashSet. Slow and Fast pointers.

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // HashSet<ListNode> set = new HashSet<>();
        // ListNode p = head;
        // while(p != null){
        //     if(!set.add(p)) return true;
        //     p = p.next;
        // }
        // return false;
        
        if(head == null) return false;
        if(head.next == null) return false;
        ListNode slow = head,fast = head.next;
        while(slow != fast){
            if(fast == null) return false;
            if(fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
        
    }
}
