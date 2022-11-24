class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if len(nums) == 0 or nums is None:
            return 0

        n = len(nums)
        count = 0

        for i in range(n - 2):
            diff = nums[i + 1] - nums[i]
            for j in range(i + 1, n - 1):
                if nums[j + 1] - nums[j] == diff:
                    count += 1
                else:
                    break
        return count

# Brute Force using nested loops
# Time Complexity: O(n^2)
# Space Complexity:O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
