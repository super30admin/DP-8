#Time: O(n)
#Space: O(1)
#Program ran on leetcode successfully

class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0
        
        prev = 0
        curr = 0
        res = 0
        
        for i in range(2, len(nums)):
            if ((nums[i] - nums[i-1]) == (nums[i-1] - nums[i-2])):
                curr = prev + 1
                res += curr
            else:
                 curr = 0
            prev = curr
        
        return res
        