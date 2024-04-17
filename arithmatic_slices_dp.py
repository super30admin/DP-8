"""
Time Complexity : O(n) where n is the length of the array
Space Complexity : O(n) where n is the length of the array or O(1) if two variables are used

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Repeated subproblems: Calcuating the difference of consecutive elements again and again. Hence dp
"""


class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if len(nums) <= 2:
            return 0
        ans = 0
        dp = [0 for _ in range(len(nums))]

        for i in range(len(nums)-3, -1, -1):
            diff = nums[i+1] - nums[i]
            if diff == nums[i+2] - nums[i+1]:
                dp[i] = dp[i+1] + 1

        for val in dp:
            ans += val

        return ans


class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if len(nums) <= 2:
            return 0
        ans = 0
        curr = 0
        prev = 0

        for i in range(len(nums)-3, -1, -1):
            diff = nums[i+1] - nums[i]
            if diff == nums[i+2] - nums[i+1]:
                curr += 1
                ans += curr
            else:
                curr = 0
            prev = curr

        return ans
