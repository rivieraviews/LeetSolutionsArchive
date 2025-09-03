class Solution {
    public boolean isValid(String s) {
        /*
        stack problem. 
        loop through, keep adding to stringbuilder stack. 
        [ ( ) ] example
        take ] and add to stack
        take ), check if ( present in stack, if not then add
        take (, check if ) present in stack - yes - pop - because it is at the top of the stack
        take [ - check if ] present - yes - pop 
        no more string to remove, no more elements in stack - return true

        example ( [ ) ]
        take (, from beginning, put in stack - top (
        take [, no partner present at top, put in stack - top [
        take ), no partner present at top, put in stack - top ) - 
            now, if closing bracket has no partner at top, that must mean string is immediately invalid.
        take ], no partner present at top, put in stack - top ]
        no more string, stack full -return false


        example ( ) ( )
        from beginning, take ( - top (
        take ), partner at top, pop partner, new top empty
        take (, empty stack, put inside
        take ), partner at top, pop partner
        no more string, empty stack - return true
        */

        Stack<Character> bracketStack = new Stack<Character>();
        int i;

        for (i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
            {
                bracketStack.push(s.charAt(i));
            }
            else if (!bracketStack.isEmpty())
            {
                if (s.charAt(i) == ')' && bracketStack.peek() == '(')
                    bracketStack.pop();
                else if (s.charAt(i) == ']' && bracketStack.peek() == '[')
                    bracketStack.pop();
                else if (s.charAt(i) == '}' && bracketStack.peek() == '{')
                    bracketStack.pop();
                else
                    return false;
            }
            else
                return false;
        }
        if (bracketStack.isEmpty() && i == s.length())
            return true;
        
        return false;
    }
}