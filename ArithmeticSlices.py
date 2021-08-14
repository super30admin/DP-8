# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

class Solution:
    def numberOfArithmeticSlices(self, A: List[int]) -> int:
        if len(A)<3:
            return 0
        
        n = len(A)
        dp = [0]*n

        for i in range(n-3,-1,-1):
            if A[i+2]-A[i+1]==A[i+1]-A[i]:
                dp[i] = dp[i+1]+1
        
        return sum(dp)