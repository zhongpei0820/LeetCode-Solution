// Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

// For example,
// MovingAverage m = new MovingAverage(3);
// m.next(1) = 1
// m.next(10) = (1 + 10) / 2
// m.next(3) = (1 + 10 + 3) / 3
// m.next(5) = (10 + 3 + 5) / 3

// Solution

public class MovingAverage {
    private Queue<Integer> q;
    private int size;
    private double sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        q = new LinkedList<>();
        this.size = size;
        sum = 0;
    }
    
    public double next(int val) {
        double result = 0;
        if(q.size() < size){
            q.add(val);
            sum += val;
            result = sum/(double)q.size();
        }else{
            sum -= q.poll();
            q.add(val);
            sum += val;
            result = sum/(double)q.size();
        }
        return result;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */