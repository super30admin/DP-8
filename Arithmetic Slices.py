# Time Complexity : O(n)
# Space Complexity : O(1)
# The code ran on LeetCode
# Maintain the number of triplets that can be formed until now and keep adding it to the result.
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        n = len(nums)
        prev = cur = 0
        res = 0

        for i in range(n-3, -1, -1):
            if nums[i+2] - nums[i+1] == nums[i+1] - nums[i]:
                cur = prev + 1
                res += cur
            else:
                cur = 0
            prev = cur
        return res