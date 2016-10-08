// Given a non-negative number represented as an array of digits, plus one to the number.

// The digits are stored such that the most significant digit is at the head of the list.

//Idea:  nums[i]++ ;if(nums[i]> 9){ nums[i] = nums[i]- 10; nums[i+1]++; i--}


public class Solution {
    public int[] plusOne(int[] digits) {
        int p = digits.length - 1;
        while(p >= 0){
            digits[p] += 1;
            if(digits[p] > 9){
                if(p != 0) digits[p] -= 10;
                p--;
            }else{
                break;
            }
        }
        if(digits[0] >= 10){
            int[] result = new int[digits.length + 1];
            for(int i = 0; i < result.length; i++){
                if(i == 0) result[i] = digits[0]/10;
                else if(i == 1) result[i] = digits[0]%10;
                else result[i] = digits[i-1];
            }
            return result;
        }
        return digits;
    }
}

// Second Version

public class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while(i >= 0){
            digits[i] += 1;
            if(digits[i] > 9 && i != 0) digits[i--] -= 10;
            else break;
        }
        if(digits[i] < 10) return digits;
        int[] ret = new int[digits.length + 1];
        ret[0] = 1;
        ret[1] = digits[0] - 10;
        for(int j = 2; j < ret.length; j++){
            ret[j] = digits[j - 1];
        }
        return ret;
    }
}
