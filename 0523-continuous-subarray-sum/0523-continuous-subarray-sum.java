class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mods = new HashMap<>();
        mods.put(0, -1);

        int currsum = 0;
        for (int i=0; i<nums.length; i++)
        {
            currsum += nums[i];
            if (!mods.containsKey(currsum % k))
                mods.put((currsum % k), i);
            else if (i - mods.get(currsum % k) >= 2)
                return true;
        }

        return false;
    }
}