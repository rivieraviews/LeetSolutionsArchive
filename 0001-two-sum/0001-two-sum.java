class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hash = new HashMap<>();
        int flag = 0;
        for (int i=0; i<nums.length; i++)
        {
            int b = target - nums[i]; //a + b = target, target - a = b
            if (hash.containsKey(b))
            {
                //if the map contains it 
                flag = 1;
                return new int[] { i, hash.get(b) };
            }
            hash.put(nums[i], i);
        }

        return new int[] {};
    }
}