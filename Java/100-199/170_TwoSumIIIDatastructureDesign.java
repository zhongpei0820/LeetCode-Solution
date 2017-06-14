// Design and implement a TwoSum class. It should support the following operations: add and find.

// add - Add the number to an internal data structure.
// find - Find if there exists any pair of numbers which sum is equal to the value.

// For example,
// add(1); add(3); add(5);
// find(4) -> true
// find(7) -> false

// Solution:
// Hash Table can be used to solve this problem.
// To find if there are any pair of numbers which sum to the value, we can simply iterate the hash table, and find if it contains value - i.
// if value - i == i and the number of i is more than 1, return true.
// if value - i != i and map contains value - i, return true.


public class TwoSum {

    HashMap<Integer,Integer> map = new HashMap<>();
    
    // Add the number to an internal data structure.
	public void add(int number) {
	    map.put(number, map.containsKey(number) ? map.get(number) + 1 : 1);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for(Map.Entry<Integer,Integer> entry : map.entrySet()){
	        int k = entry.getKey();
	        if((value - k == k && entry.getValue() > 1) || (value - k != k && map.containsKey(value - k))) return true;
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);