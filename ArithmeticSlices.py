# 413. Arithmetic Slices
# Time complexity: O(n)
# Space complexity: O(1)

class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if len(nums) < 3:
            return 0
        prev = 0
        curr = 0
        count = 0
        for i in range(2,len(nums)):
            if nums[i]-nums[i-1] == nums[i-1]-nums[i-2]:
                curr = prev + 1
                prev = curr
                count = count+ curr
            else:
                prev = 0
        return count
