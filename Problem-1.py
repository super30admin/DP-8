# Time Complexity : O(N)   # Single pass through the array
# Space Complexity : O(1)  # Only counters are used
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# An arithmetic slice requires at least 3 numbers with constant difference.
# If nums[i]-nums[i-1] == nums[i-1]-nums[i-2], we extend the previous slice count.
# Add the current slice count to result to accumulate total slices.

class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        curr = 0
        res = 0

        for i in range(2, len(nums)):
            if nums[i] - nums[i-1] == nums[i-1] - nums[i-2]:
                curr += 1
                res += curr
            else:
                curr = 0

        return res