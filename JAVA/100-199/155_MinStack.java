// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

// push(x) -- Push element x onto stack.
// pop() -- Removes the element on top of the stack.
// top() -- Get the top element.
// getMin() -- Retrieve the minimum element in the stack.
// Example:
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin();   --> Returns -3.
// minStack.pop();
// minStack.top();      --> Returns 0.
// minStack.getMin();   --> Returns -2.

// Solution:
// First idea is that we can record the minimal number of this stack.
// Each time we push an element into the stack, compare it with the current minimal value.
// But, if we pop a element out of the stack, and this element is the minimal. How can we find the minimal of the rest?
// One solution is that, when we push a new element into the stack, and if this element is a new minimal, we first push the old minimal 
// into the stack befor pushing this element.
// So, when we pop the minimial out of the stack, the minimal of the rest is at the top of the stack.
// Therefore, we can find the minimal of the rest by poping the top of stack.

public class MinStack {
    int min;
    Stack<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(x <= min){ stack.push(min); min = x;}
        stack.push(x);
    }
    
    public void pop() {
        if(stack.peek() == min){stack.pop(); min = stack.pop();}
        else stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */