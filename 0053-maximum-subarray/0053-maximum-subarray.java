class Solution {
    public int maxSubArray(int[] nums) {
        //divide and conquer

        return divideAndConquer(nums, 0, nums.length - 1);
        
    }

    private int divideAndConquer(int[] nums, int left, int right)
    {
        if (left == right)
            return nums[left];
        
        int mid = (left + right) / 2; 

        int leftsum = divideAndConquer(nums, left, mid);
        int rightsum = divideAndConquer(nums, mid + 1, right);
        int crosssum = findCrossingMax(nums, left, mid, right);

        return Math.max(Math.max(leftsum, rightsum), crosssum);
    }

    private int findCrossingMax(int[] nums, int left, int mid, int right)
    {
        //find mid to left - greatest sum
        int sum = 0;
        int maxleftsum = Integer.MIN_VALUE;
        int maxrightsum = Integer.MIN_VALUE;
        for (int i = mid; i >= left; i--)
        {
            sum += nums[i];
            maxleftsum = Math.max(maxleftsum, sum);
        }

        sum = 0;
        //find mid to right - greatest sum
        for (int i = mid + 1; i <= right; i++)
        {
            sum += nums[i];
            maxrightsum = Math.max(maxrightsum, sum);
        }

        return maxleftsum + maxrightsum;
    }

}