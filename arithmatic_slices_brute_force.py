"""
Time Complexity : O(n*n) where n is the length of the array
Space Complexity : O(1) as no auxillary data structure is used

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Nested iteration, create all the possible subArrays having length greater than or equal to 3
"""


class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if len(nums) <= 2:
            return 0
        ans = 0

        for i in range(len(nums)-2):
            diff = nums[i+1] - nums[i]
            for j in range(i+1, len(nums)-1):
                if nums[j+1] - nums[j] == diff:
                    ans += 1
                else:
                    break

        return ans
