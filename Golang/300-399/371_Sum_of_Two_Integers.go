//Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
//
//Example:
//Given a = 1 and b = 2, return 3.
//
//
//Credits:Special thanks to @fujiaozhu for adding this problem and creating all test cases.

func getSum(a int, b int) int {
    sum := a ^ b
    carry := (a & b) << 1
    if carry == 0 {
        return sum
    }
    return getSum(sum,carry)
}