class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target)
    {
        map<int, int> comp;

        for (int i = 0; i < nums.size(); i += 1)
        {
            auto pos = comp.find(target - nums[i]);
            if (pos != comp.end())
                return {pos->second, i};
            comp[nums[i]] = i;
        }
        return {-1, -1};
    }
};