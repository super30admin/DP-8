# Time Complexity : O(N) as we are iterating through the nums list
# Space Complexity : O(N) as we are using extra space to store the dp array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using a dynamic programming approach to count the number of arithmetic slices in the given list.
# I maintain a dp array where dp[i] represents the number of arithmetic slices ending at index i.
# I iterate through the list starting from index 2 and check if the current element, the previous element, and the element before that form an arithmetic sequence.
# If they do, I update dp[i] to be dp[i-1] + 1, indicating that we can extend the arithmetic slices ending at index i-1 by including the current element.
# I also maintain a count variable to keep track of the total number of arithmetic slices found so far by adding dp[i] to it.
# Finally, I return the count as the result.
from typing import List
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [0] * n
        count = 0
        for i in range(2,n):
            if nums[i] - nums[i-1] == nums[i-1] - nums[i-2]:
                dp[i] = dp[i-1] + 1
            else:
                dp[i] = 0
            count += dp[i]
        return count        