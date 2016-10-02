// Implement the following operations of a stack using queues.

// push(x) -- Push element x onto stack.
// pop() -- Removes the element on top of the stack.
// top() -- Get the top element.
// empty() -- Return whether the stack is empty.

class MyStack {
    // Push element x onto stack.
    Queue<Integer> q = new LinkedList<>();
    public void push(int x) {
        if(q.isEmpty()){
            q.add(x);
        }else{
            int[] temp = new int[q.size()];
            for(int i = 0; i < temp.length; i++){
                temp[i] = q.poll();
            }
            q.add(x);
            for(int i = 0; i < temp.length; i++){
                q.add(temp[i]);
            }
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        q.poll();
    }

    // Get the top element.
    public int top() {
        return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}
