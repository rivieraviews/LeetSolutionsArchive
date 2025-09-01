class Solution {
    public String reverseWords(String s) {
        //reverse word using stack approach

        String currentWord = "";
        Stack<String> reversed = new Stack<>();
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) != ' ')
            {
                currentWord += s.charAt(i);
            }
            else
            {
                if (!currentWord.isEmpty())
                {
                    reversed.push(currentWord);
                    currentWord = "";
                }
            }
        }

        if (!currentWord.isEmpty())
            reversed.push(currentWord);

        String result = "";

        while (!reversed.isEmpty())
        {
            result += reversed.pop();
            result += " ";
        }

        return result.trim();
    }
}