class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] diff = new int[temperatures.length];
        Stack<Integer> tempStack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++)
        {
                while (!tempStack.isEmpty() && temperatures[i] > temperatures[tempStack.peek()])
                {
                    diff[tempStack.peek()] = i - tempStack.peek();
                    tempStack.pop();
                }
                tempStack.push(i);
        }

        return diff;
    }
}

/*
    using stacks to solve. 

    og array : [ 73, 74, 75, 71, 69, 72, 76, 73 ]

    stack1 : same as array [last entry, ... , first entry]

    new stack : ??

     what should we store in the stack, and when do we pop from it?

    intuition : you can skip some elements, reduce redundant checks
    75 need not be checked by 69 as 69 less than 71 which is less than 75.

    array : 73
    stack : 73 top

    array : 74
    stack : 73
    checking: stack.peek is less than current array, a[i] > stack.peek
        store difference in result array
        pop from stack : empty
        push to stack : 74 top
    
    array : 75
    stack : 74 top
    checking : current array val is greater than stack top
        store diff
        pop from stack : empty
        push to stack : 75 top
    
    array : 71
    stack : 75 top
    checking : array val is LESS than stack top
        push to stack : 75, 71 top
    
    array : 69
    stack : 75, 71 top
    checking : array val is LESS than stack top
        push to stack : 75, 71, 69 top
    
    note : stack elements are being stored in sorted order - top is least value, bottom is highest value

    array : 72
    stack : 75, 71, 69 top
    checking : array val is GREATER than stack top
        store diff (position of 72 - position of 69) inside result array (at the same position that 69 is in, in the original array)
        pop from stack : 75, 71 top
        checking again: array val 72 is greater than stack top 71. 
            store diff for 71 in the same way as prev
            pop from stack : 75 top
            checking again : stack top is now greater than array val.
                push to stack : 75, 72 top
        note : this is looking like a while condition (while stack top is less than current array val)
    
    array : 76
    stack : 75, 72 top
    checking : array val is greater than stack top
        store diff for 72 as before
        pop from stack : 75 top
        checking : array val greater than stack top
            store diff for 75 as prev
            pop from stack: empty
            push to stack : 76 top
    
    array : 73
    stack : 76 top
    checking : 73 < 76
        push to stack : 76, 73 top
    
    end of array, so check if stack is empty. if not, then number of remaining numbers in stack will be the number of zeroes added to result array where we are storing differences. if yes, then return array of differences.

 */