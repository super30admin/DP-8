class Solution:
    
    """
    Description: Given an integer array nums, return the number of arithmetic subarrays of nums
    
    Time Complexity: O(n)
    Space Complexity: O(n)
    
    Approach:
    - create a dp array with same length as nums with all zeros, start result variable = 0
    - starting from 2nd index, check if difference of 3 consecutive numbers are same
      + if yes, add 1 to previous element of dp array, and add to result
      + if no, continue the loop
    - return result as the final answer
    """
    
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        
        dp = [0]*len(nums)
        result = 0
        
        for i in range(2, len(nums)):
            if nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]:
                dp[i] = 1 + dp[i - 1]
                result += dp[i]
                
        return result
