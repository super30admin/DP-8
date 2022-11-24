class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if len(nums) == 0 or nums is None:
            return 0

        n = len(nums)
        curr = 0
        count = 0
        for i in range(2, n):
            if nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]:
                curr += 1
                count += curr
            else:
                curr = 0

        return count

# Top Down Dynamic Programming without DP array
# Time Complexity: O(n)
# Space Complexity:O(1).
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
