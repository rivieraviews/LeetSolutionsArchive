class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        if (t.length() != s.length())
            return false;

        for (char ch : s.toCharArray())
        {
            sMap.put(ch, sMap.getOrDefault(ch, 0)+1);
        }

        for (char ch : t.toCharArray())
        {
            tMap.put(ch, tMap.getOrDefault(ch, 0)+1);
        }

        // for (char ch : sMap.keySet())
        // {
        //     if (sMap.get(ch) != tMap.getOrDefault(ch, 0))
        //         return false;
        // }

        // return true;

        return tMap.equals(sMap);

    }
}