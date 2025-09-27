class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;
        int[] right = new int[n];
        int[] products = new int[n];
        for (int i=0; i<n; i++)
        {
            if (i == 0)
            {
                products[i] = 1;
            }
            else
            {
                products[i] = products[i-1] * nums[i-1];
            }
        }

        for (int i = n-1; i>=0; i--)
        {
            if (i == (n-1))
            {
                right[i] = 1;
            }
            else
            {
                right[i] = right[i+1] * nums[i+1];
            }
        }

        for (int i = 0; i<n; i++)
        {
            products[i] = products[i] * right[i];
        }

        return products;
    }
}