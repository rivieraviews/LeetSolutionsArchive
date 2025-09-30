class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagrams = new HashMap<>();
        for (String s : strs)
        {
            char[] ch = s.toCharArray(); //taking out eat as e,a,t
            Arrays.sort(ch); //sorting e,a,t to a,e,t
            //now store this as a key
            String key = new String(ch);
            if (!anagrams.containsKey(key)) //does not contain our aet key
            {
                anagrams.put(key, new ArrayList<>()); //because our new anagram is currently not linked to anything
            }
            anagrams.get(key).add(s); //adding eat value to aet key
        }

        return new ArrayList<>(anagrams.values());
    }
}