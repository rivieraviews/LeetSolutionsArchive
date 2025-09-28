class Solution {
    public String minWindow(String s, String t) {
        //classic sliding window problem

        /*
            1. count frequency ofcharacters in t
            2. left right pointers in s for window
            3. left static, increase right until all of t is found
            4. right static, move left towards right until all of t is contained in min length
         */

        HashMap<Character, Integer> needMap = new HashMap<>();

        for (int i = 0; i<t.length(); i++)
        {
            char ch = t.charAt(i);
            if (!needMap.containsKey(ch))
                needMap.put(ch, 1);
            else
            {
                int temp = needMap.get(ch);
                needMap.replace(ch, temp + 1);
            }
        }

        //above code finds freq of each character in t

        int left = 0, right, globalmin = Integer.MAX_VALUE;
        String res = "";

        HashMap<Character, Integer> haveMap = new HashMap<>();
        
        for (right = 0; right < s.length(); right++)
        {
            char ch = s.charAt(right);
            haveMap.put(ch, haveMap.getOrDefault(ch, 0) + 1);
            //if char is not present prev, then make it present now

            //check if have and need are same, then proceed
            while (isValid(needMap, haveMap))
            {
                if ((right - left + 1) < globalmin)
                {
                    globalmin = right - left + 1;
                    res = s.substring(left, right + 1);
                }

                char leftch = s.charAt(left);
                haveMap.put(leftch, haveMap.get(leftch) - 1);

                if (haveMap.get(leftch) == 0)
                {
                    haveMap.remove(leftch);
                }
                left++;
            }
        }

        return res;
    }

    private boolean isValid(HashMap<Character, Integer> needMap, HashMap<Character, Integer> haveMap)
    {
        for ( char ch : needMap.keySet())
        {
            if (haveMap.getOrDefault(ch, 0) < needMap.get(ch))
            {
                return false;
            }
        }

        return true;
    }
}