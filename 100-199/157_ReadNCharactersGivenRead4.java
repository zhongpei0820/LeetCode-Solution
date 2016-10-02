// The API: int read4(char *buf) reads 4 characters at a time from a file.

// The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

// By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

// Note:
// The read function will only be called once for each test case.

//Solution:
//The read function read n characters from a file to its buffer.
//The intuition is call read4 repeateadly.
//For example, if we want to read 10 characters, we have to use read4 three times.
//And at the last time we only need the first two characters from read4.
//So, in each iteration, we have to read the characters read by read4 and check if we need all the four characters.(e.g. how many characters need to read).
//Also, we have to consider if n is larger than the total length of the file.

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        boolean eof = false;
        int total = 0;
        char[] tmp = new char[4];
        while(!eof && total < n){
            int count = read4(tmp);
            eof = count < 4;
            count = Math.min(count,n - total);
            for(int i = 0; i < count; i++) buf[total++] = tmp[i];
            
        }
        return total;
    }
}