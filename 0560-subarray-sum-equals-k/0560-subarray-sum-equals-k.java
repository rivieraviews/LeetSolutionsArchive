class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixsum = new HashMap<>();
        prefixsum.put(0,1);
        int curSum = 0, c = 0, prefix;
        for (int i = 0; i<nums.length; i++)
        {
            curSum += nums[i];
            prefix = curSum - k;
            if (prefixsum.containsKey(prefix))
                c += prefixsum.get(prefix);
            prefixsum.put(curSum, prefixsum.getOrDefault(curSum, 0)+1);
            // current - prev = k
            //-prev = k - current
            // prev = current - k
        }

        return c;
    }
}