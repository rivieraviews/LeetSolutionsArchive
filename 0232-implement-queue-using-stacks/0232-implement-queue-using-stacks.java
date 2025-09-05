class MyQueue {

    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    public MyQueue() {
        this.inputStack = new Stack<>();
        this.outputStack = new Stack<>();
    }
    
    public void push(int x) {
        inputStack.push(x);
    }
    
    public int pop() {
        //queue er moton popping chaile aage transfer from inputStack to outputStack tarpor pop
        //so call transfer method aage
        stackTransfer();
        return outputStack.pop();
    }
    
    public int peek() {
        //ekhaneo transfer tarpor peek
        stackTransfer();
        return outputStack.peek();
    }
    
    public boolean empty() {
        //ekhane bas empty check
        //dujoner e empty check
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    //need a private method for transferring from inputStack to outputStack
    private void stackTransfer() {
        //input ey dhorei nilam jinish ache, then only transfer if output is empty
        if (outputStack.isEmpty())
        {
            while (!inputStack.isEmpty())
            {
                //jotokkhon na input is becoming empty, keep popping from input and pushing to output;
                outputStack.push(inputStack.pop());
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */