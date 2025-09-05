class MinStack {

    private Stack<Integer> minStack;
    private Stack<Integer> minimums;

    public MinStack() {
        this.minStack = new Stack<>();
        this.minimums = new Stack<>();
    }
    
    public void push(int val) {
        minStack.push(val);
        if (!minimums.isEmpty() && val <= minimums.peek())
            minimums.push(val);
        else if (minimums.isEmpty())
            minimums.push(val);
    }
    
    public void pop() {
        int top = minStack.pop();
        if (!minimums.isEmpty() && top == minimums.peek())
            minimums.pop();
    }
    
    public int top() {
        return minStack.peek();
    }
    
    public int getMin() {
        /*
        two stacks approach.
        data stack, min stack. 
         */
        if (minimums.isEmpty())
            return minStack.peek();
        else
            return minimums.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */