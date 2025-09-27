class Solution {
    public int maxProduct(int[] nums) {
        int maxSoFar, minSoFar, globalMax;
        maxSoFar = nums[0];
        minSoFar = nums[0];
        globalMax = nums[0];
        for (int i = 1; i<nums.length; i++)
        {
            int maxproduct = maxSoFar * nums[i];
            int minproduct = minSoFar * nums[i];

            maxSoFar = Math.max(Math.max(minproduct, maxproduct), nums[i]);
            minSoFar = Math.min(Math.min(minproduct, maxproduct), nums[i]);

            globalMax = Math.max(maxSoFar, globalMax);
        }

        return globalMax;
    }
}