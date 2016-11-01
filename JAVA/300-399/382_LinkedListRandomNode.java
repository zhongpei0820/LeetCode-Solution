// Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

// Follow up:
// What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

// Example:

// // Init a singly linked list [1,2,3].
// ListNode head = new ListNode(1);
// head.next = new ListNode(2);
// head.next.next = new ListNode(3);
// Solution solution = new Solution(head);

// // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
// solution.getRandom();



// Solution:
// This problem invovles a random sampling algorithm called Reservior Sampling.
// If we know the length of the list, this problem is simple : the probablity of choosing each element is 1/n where n is the number 
// of elements in the list.
// And we can use Random function to randomly generate a number from 0 to n - 1, and return that element.
// If we do not know the size of our input list, how can we be sure that each number have the eqaul probability to be chosen?
// Reservior Sampling provide such way to ensure the equal probability:
// Traverse this list, 
// When we traverse the first element, the probability of choosing this element is one since it is the only element traversed so far.
// Then, when we traverse the second element, the probability of choosing this element should be 1/2, so we randomly generate 
// a number between 1 and 2, if it is 1 then we keep choosing the first element. Otherwise, we choose the second element.
// Then, we move to the third element, and the probability of choosing the 3rd one is 1/3, since there are 3 elements we know.
// And we generate a random number between 1, 2 and 3. If it is 3, we choose the thrid element. If not, we keep the choosing the 
// element we choosed between 1 and 2.
// So on so forth.

// Proof:
// When there is only one element: The probablity = 100%
// When there are two elements: P = 50%, since we randomly choose from that two.
// When there are three elements: P(choose the thrid one) = 1 / 3, since we randomly generate number between 1, 2 and 3.
// P(choose the first one) = 50% * (1 - 1 / 3) = 50% * 2 / 3 = 1 / 3. (P(choose first one in previous step) * P(choose first one in current step))
// The same goes to P(choose the second one) = 1 / 3.

// Reservior Sampling Wiki : https://en.wikipedia.org/wiki/Reservoir_sampling

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    ListNode head;
    Random random;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        random = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode node = this.head;
        int res = 0;
        int count = 0;
        while(node != null){
            if(random.nextInt(count + 1) == count) res = node.val;
            node = node.next;
            count++;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */