class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;

        int area = Integer.MIN_VALUE;

        while (i<j)
        {
            area = Math.max(((j-i)*Math.min(height[i], height[j])), area);
            if (height[i] < height[j])
                i++;
            else if (height[j] < height[i])
                j--;
            else
                i++; //or j++
        }

        return area;
    }
}