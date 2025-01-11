# The numberOfArithmeticSlices method calculates the number of arithmetic subarrays in the list.

# Dynamic Programming Approach:
# - Use a `dp` array where `dp[i]` stores the count of arithmetic subarrays ending at index `i`.
# - For each element from index 2 onward:
#   - Check if the current element forms an arithmetic sequence with the previous two.
#   - If yes, update `dp[i]` to `dp[i-1] + 1`.

# Return the sum of the `dp` array as the total count.

# TC: O(n) - Single traversal of the array.
# SC: O(n) - Space for the `dp` array.


from typing import List


class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        dp=[0]*len(nums)
        for i in range(2,len(nums)):
            if nums[i]-nums[i-1]==nums[i-1]-nums[i-2]:
                dp[i]=dp[i-1]+1
        return sum(dp)