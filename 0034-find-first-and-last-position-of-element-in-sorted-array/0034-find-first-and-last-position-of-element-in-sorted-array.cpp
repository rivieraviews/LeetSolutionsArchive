class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target)
    {
        int c = count(nums.begin(), nums.end(), target);
        vector<int> ans;
        if (c != 0)
        {
            auto it = find(nums.begin(), nums.end(), target);
            int first = it - nums.begin();
            int last = first + c - 1;
            ans = {first,last};
        }
        else
            ans = {-1,-1};
        return ans;
    }
};