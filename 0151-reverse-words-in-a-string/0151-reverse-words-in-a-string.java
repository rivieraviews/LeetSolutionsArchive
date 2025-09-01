class Solution {
    public String reverseWords(String s) {
        //reverse word using stack approach

        StringBuilder currentWord = new StringBuilder();
        Stack<StringBuilder> reversed = new Stack<>();

        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) != ' ')
            {
                currentWord.append(s.charAt(i));
            }
            else
            {
                if (!currentWord.isEmpty())
                {
                    reversed.push(new StringBuilder(currentWord));
                    currentWord.setLength(0);
                }
            }
        }

        if (!currentWord.isEmpty())
            reversed.push(currentWord);

        StringBuilder result = new StringBuilder();

        while (!reversed.isEmpty())
        {
            result.append(reversed.pop());
            if (!reversed.isEmpty())
                result.append(" ");
        }

        return result.toString();
    }
}