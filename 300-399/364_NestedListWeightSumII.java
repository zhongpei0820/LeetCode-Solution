// Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

// Each element is either an integer, or a list -- whose elements may also be integers or other lists.

// Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.

// Example 1:
// Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1, one 2 at depth 2)

// Example 2:
// Given the list [1,[4,[6]]], return 17. (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

// Solution one : 

// Add all elements into the queue, and store the size of queue in variable 'size'.
// While queue is not empty, iterate 'size' elemnts in the queue,
// If the element is an integer, add it to sum,
// If not, add the elements in the list into the queue.
// add the sum to the arrayList.
// Repeat until the queue is empty.
// Add the sums in the arraylist.

public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int res = 0;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        while(queue.size() > 0){
            int size = queue.size();
            int sum = 0;
            for(int i = 0; i < size; i++){
                NestedInteger ni = queue.poll();
                if(ni.isInteger()) sum += ni.getInteger();
                else queue.addAll(ni.getList());
            }
            arrayList.add(sum);
        }
        
        int level = 1;
        for(int i = arrayList.size() - 1; i >= 0; i--){
            res += arrayList.get(i) * level++;
        }
        return res;
    }
}


// Solution two: A little improvement of solution one
// Acutally we do not need a arraylist to hold the sum for each level.
// The sum in the depthest level can be computed by sum of depthest -1 level + sum of depthest level.
// For example:
// [1,[1,[2]]]
// sum of the first level = 1, res = 1,
// sum of the second level = sum of the first level + 1 = 2
// res += sum of the second level = 1 + 2 = 3.
// sum of the third level = sum of the second level + 2 = 4
// res += sum of the third level = 3 + 4 = 7.
// So on so forth. 

public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int res = 0;
        int sum = 0;
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        while(queue.size() > 0){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                NestedInteger ni = queue.poll();
                if(ni.isInteger()) sum += ni.getInteger();
                else queue.addAll(ni.getList());
            }
            res += sum;
        }
        return res;
    }
}