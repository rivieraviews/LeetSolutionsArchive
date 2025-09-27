class Solution {
public int lengthOfLongestSubstring(String s) {
        int start = 0, globalmax = 0, len = 0;
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (int i=0; i<s.length(); i++)
        {
            if (charMap.containsKey(s.charAt(i)) && (charMap.get(s.charAt(i)) >= start))
            {
                //if ((charMap.get(s.charAt(i)) >= start))
                    start = charMap.get(s.charAt(i)) + 1;
            }
            charMap.put(s.charAt(i), i);
            len = i - start + 1;
            globalmax = Math.max(globalmax, len);
        }

        return globalmax;
    }
};