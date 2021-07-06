class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0
        count = 0
        prev = 0
        for i in range(2, len(nums)):
            if (nums[i]-nums[i-1] == nums[i-1]-nums[i-2]):
                prev = 1+prev
                count += prev
            else:
                prev = 0
        return count
