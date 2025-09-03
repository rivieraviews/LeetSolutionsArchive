class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        int left = 0;
        int right = words.length - 1;

        while (left < right)
        {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left ++;
            right --;
        }

        StringBuilder result = new StringBuilder();
        for(String word : words)
        {
            if (!word.isEmpty())
            {
                if (result.length() > 0)
                {
                    result.append(" ");
                }
                result.append(word);
            }
        }

        return result.toString();
    }
}