class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        if target in nums:
            return nums.index(target)
        else:
            f=0
            for i in range(len(nums)-1):
                if target > nums[i] and target < nums[i+1]:
                    f=1
                    return i+1
            if f == 0:
                if target < nums[0]:
                    return 0
        
        return len(nums)