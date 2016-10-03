// Description:

// Count the number of prime numbers less than a non-negative number, n.

//Solution : First, we have to decide whether an integer is prime or not.
// 			 A brute way to do is to check if N is divisible by 2 to N - 1, but it will cost O(n).
// 			 Actually, if N = P * Q, and P <= Q, we don't need to check N = Q * P again. So, we only need to check if N is divisible by 2 to Sqrt(N).
// 			 A more generic idea for this problem is Sieve of Eratosthenes:
// 			 First, we use an array isPrime to cache if n is a prime. Initialy all elements is true.
// 			 Then strating from 2, all multiples of 2 is not prime, so we mark them as false, then same for 3.
// 			 Because 4 is already marked as false, all its multiples are multiples of 2. So we skip 4.
//			 Then we jump to 5, because 5*2, 5*3 and 5*4 are already marked as false in the previous steps, so we starts from 25.
// 			 The loop ends at i*i < n.


public class Solution {
    public int countPrimes(int n) {
        if(n < 2) return 0;
        boolean[] isPrime = new boolean[n];
        int ret = 0;
        for(int i = 0; i < n; i++){
            isPrime[i] = true;
        }
        for(int i = 2; i * i < n; i++){
            if(!isPrime[i]) continue;
            for(int j = i * i; j < n; j += i){
                isPrime[j] = false;
            }
        }
        for(int i = 2; i < n; i++){
            if(isPrime[i]) ret++;
        }
        return ret;
    }
}