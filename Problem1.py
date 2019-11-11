# Time Complexity: O (n)(Where n length of list) 
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Can be solved using dynamic programming.

class Solution:
    def numberOfArithmeticSlices(self, A: List[int]) -> int:
        dp = [0 for i in range(len(A))]
        ans = 0
        for i in range(2, len(A)):
            if (A[i] - A[i-1] == A[i-1] - A[i-2]):
                dp[i] = 1 + dp[i-1]
                ans += dp[i]
        return ans
