//Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
//
//The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
//
//You may assume that each input would have exactly one solution and you may not use the same element twice.
//
//
//Input: numbers={2, 7, 11, 15}, target=9
//Output: index1=1, index2=2
//

/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(numbers, target) {
    var res = [];
    for(let i = 0; i < numbers.length; i++){
        var index = binarySearch(numbers,target - numbers[i],i + 1,numbers.length - 1);
        if(index !== -1){
            res.push(i + 1);
            res.push(index + 1);
            return res;
        }
    }
    return res;
};

function binarySearch(array,key,start,end){
    if(end < start) return -1;
    var mid = Math.ceil(start + (end - start) / 2);
    if(array[mid] === key) return mid;
    else if(array[mid] < key) return binarySearch(array,key,mid + 1,end);
    return binarySearch(array,key,start,mid - 1);
}
