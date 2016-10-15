// Given two 1d vectors, implement an iterator to return their elements alternately.

// For example, given two 1d vectors:

// v1 = [1, 2]
// v2 = [3, 4, 5, 6]
// By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

// Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

// Clarification for the follow up question - Update (2015-09-18):
// The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

// [1,2,3]
// [4,5,6,7]
// [8,9]
// It should return [1,4,8,2,5,9,3,6,7].

// Solution:
// Iterate both lists, if index % 2 == 0, get element from the first list, else get from another list.
// If p1 > list1.size(), get element from list2.
// If p2 > list2.size(), get element from list1.

public class ZigzagIterator {
    
    List<Integer> list1,list2;
    int index;
    int p1, p2;
    int size1, size2;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        index = 0;
        list1 = v1;
        size1 = v1.size();
        list2 = v2;
        size2 = v2.size();
        p1 = 0;
        p2 = 0;
    }

    public int next() {
        if(index % 2 == 0 && p1 < size1){ 
            index++;
            return list1.get(p1++);
        }
        if(index % 2 == 1 && p2 < size2){
            index++;
            return list2.get(p2++);
        } 
        if(p1 < size1){
            index++;
            return list1.get(p1++);
        }
        index++;
        return list2.get(p2++);
    }

    public boolean hasNext() {
        return p1 < size1 || p2 < size2;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */