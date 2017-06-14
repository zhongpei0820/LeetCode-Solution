// Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

// Each element is either an integer, or a list -- whose elements may also be integers or other lists.

// Example 1:
// Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)

// Example 2:
// Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)

//Solution 1 : Queue

// Add all the elements into a queue, and record the size of the queue.
// While i < size, poll the first elements out of the queue, and check if it is an integer:
// 		If yes, add it to the sum,
// 		If not, getList(), then add all of the elements of the list into the queue.
// Repeat while the queue is not null.

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        int res = 0;
        int level = 1;
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        while(queue.size() > 0){
            int size = queue.size();
            int sum = 0;
            for(int i = 0; i < size; i++){
                NestedInteger temp = queue.poll();
                if(temp.isInteger()) sum += temp.getInteger();
                else queue.addAll(temp.getList());
            }
            res += level * sum;
            level++;
        }
        return res;
    }
}

// Solution 2 : DFS

public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList,1);
    }
    
    private int dfs(List<NestedInteger> nestedList, int level){
        int res = 0;
        for(int i = 0; i < nestedList.size(); i++){
            NestedInteger temp = nestedList.get(i);
            if(temp.isInteger()) res += level * temp.getInteger();
            else res += dfs(temp.getList(), level + 1);
        }
        return res;
    }
}