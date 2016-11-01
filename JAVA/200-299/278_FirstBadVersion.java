// You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

// Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

// You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

//Solution:
// Intuition sugguests binary search, since it is a sorted array and we need to minimize the call to API possible.
// First we check the mid, if mid is bad, the first bad version may appear in the versions before mid.
// If all versions before mid is good, then the first bad version is mid.
// If mid is good, the first bad version appears in the versions after mid.
// If mid is bad, set high to mid. If mid is good, set low to mid + 1, because the first bad version may appear at mid + 1 to high.
// If low >= high, the last low is the first bad version.

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1,high = n;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(isBadVersion(mid)) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}
