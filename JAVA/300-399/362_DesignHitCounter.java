// Design a hit counter which counts the number of hits received in the past 5 minutes.

// Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to the system in chronological order (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.

// It is possible that several hits arrive roughly at the same time.

// Example:
// HitCounter counter = new HitCounter();

// // hit at timestamp 1.
// counter.hit(1);

// // hit at timestamp 2.
// counter.hit(2);

// // hit at timestamp 3.
// counter.hit(3);

// // get hits at timestamp 4, should return 3.
// counter.getHits(4);

// // hit at timestamp 300.
// counter.hit(300);

// // get hits at timestamp 300, should return 4.
// counter.getHits(300);

// // get hits at timestamp 301, should return 3.
// counter.getHits(301); 
// Follow up:
// What if the number of hits per second could be very large? Does your design scale?


// Solution:
// We only have to record 300 records at most, so we can define an array to store all the records.
// For scaling, we define another array to store the hit times per sec.
// The key is how to map the array index to the timestamp -- timestamp % 300.
// If timestamp != time[timestamp % 300], means the value in time[timestamp % 300] can be abandoned, 
// Because timestamp >= time[timestamp % 300] + 300 at least.
// In the getHits, just sum up all hitTimes[i] where time[i] > timestamp - 300.


public class HitCounter {
    
    int[] time;
    int[] hitTimes;
    
    /** Initialize your data structure here. */
    public HitCounter() {
        time = new int[300];
        hitTimes = new int[300];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if(time[index] != timestamp){
            time[index] = timestamp;
            hitTimes[index] = 1;
        }else{
            hitTimes[index]++;
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int sum = 0;
        for(int i = 0; i < 300; i++){
            if(time[i] > timestamp - 300){
                sum += hitTimes[i];
            }
        }
        return sum;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */