// Write a program to find the node at which the intersection of two singly linked lists begins.


// For example, the following two linked lists:

// A:          a1 → a2
//                   ↘
//                     c1 → c2 → c3
//                   ↗            
// B:     b1 → b2 → b3
// begin to intersect at node c1.

//Idea: 1. HashSet

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        HashSet<ListNode> set = new HashSet<>();
        while(p1 != null){
            set.add(p1);
            p1 = p1.next;
        }
        while(p2 != null){
            if(!set.add(p2)) return p2;
            p2 = p2.next;
        }
        return null;
    }
}

//2. Two Pointers

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        int lenA = 0, lenB = 0;
        while(p1 != null){
            lenA++;
            p1 = p1.next;
        }
        while(p2 != null){
            lenB++;
            p2 = p2.next;
        }
        p1 = headA;
        p2 = headB;
        if(lenA > lenB){
            for(int i = 0; i < lenA - lenB; i++){
                p1 = p1.next;
            }
        }else{
            for(int i = 0; i < lenB - lenA; i++){
                p2 = p2.next;
            }
        }
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}

