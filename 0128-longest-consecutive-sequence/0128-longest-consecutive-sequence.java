class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new HashSet<>();

        for (int n : nums)
        {
            numbers.add(n);
        }

        int c = 0, maxlen = 0, start;
        for (int n : numbers)
        {
            if (!numbers.contains(n-1))
            {
                start = n + 1; c = 1;
                while (numbers.contains(start))
                {
                    c++;
                    start += 1;
                }
                maxlen = Math.max(maxlen, c);
                c = 0;
            }
        }
        return maxlen;
    }
}