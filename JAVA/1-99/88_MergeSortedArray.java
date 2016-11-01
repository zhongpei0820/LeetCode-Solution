// Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

//Idea:Two pointers, merge sort, O(n)

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        for(int i = 0; i < m; i++){
            temp[i] = nums1[i];
        }
        int p1 = 0, p2 = 0;
        int count = 0;
        while(p1 < m && p2 < n){
            if(temp[p1] < nums2[p2]){
                nums1[count] = temp[p1];
                p1++;
            }else{
                nums1[count] = nums2[p2];
                p2++;
            }
            count++;
        }
        if(p1 >= m){
            for(int i = p2; i < n; i++){
                nums1[count++] = nums2[i];
            }
        }
        if(p2 >= n){
            for(int i = p1; i < m; i++){
                nums1[count++] = temp[i];
            }
        }
    }
}
