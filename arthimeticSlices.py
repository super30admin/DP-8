class Solution:
    # bottom up dp
    # TC : O(n)
    # SC : O(1)
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if nums is None or len(nums) < 3:
            return 0
        n = len(nums)
        ct = 0
        prev = 0
        for i in range(n-3,-1,-1):
            if nums[i+2] - nums[i+1] == nums[i+1] - nums[i]:
                prev = prev+1
            else:
                prev = 0
            ct += prev
        return ct
        