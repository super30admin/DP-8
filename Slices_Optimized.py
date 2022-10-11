# Time complexity : O(n)
# Space complexity : O(n)
# Leetcode : Solved and submitted

class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
       # check for null case
        if not nums or len(nums) == 0:
            return 0
         
        # find the length of nums list, declare the count and dp array of size n
        n = len(nums)
        dp = [0 for _ in range(n)]
        count = 0
        
        # start traversing from the last but 3rd element until we reach the first index
        for i in range(n-3,-1,-1):
            # check if we have an aithmetic slice
            if nums[i+2] - nums[i+1] == nums[i+1] - nums[i]: 
                # increment the dp by 1 with the value of the previous slice
                dp[i] = dp[i+1] + 1
                
                # sum up the count with the current dp values
                count += dp[i]
        
        # return the final count as the result
        return count
