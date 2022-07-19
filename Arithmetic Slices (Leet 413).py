'''
Brute Force
Time: O(n^2)
Space: O(1)
'''

class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        
        if len(nums) < 3:
            return 0
        
        count = 0
        for i in range(len(nums)-2):
            for j in range(i+2,len(nums)):
                if nums[j] - nums[j-1] == nums[i+1] - nums[i]:
                    count += 1
                else:
                    break
        return count


'''
Using DP (first to last)
Time: O(n)
Space: O(n)
'''

class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        
        if len(nums) < 3:
            return 0
        
        dp = [0 for _ in range(len(nums))]
        count = 0
        for i in range(2,len(nums)):
            if nums[i] - nums[i-1] == nums[i-1] - nums[i-2]:
                dp[i] = 1 + dp[i-1]
                count += dp[i]
                
        return count


'''
Using DP (last to first)
Time: O(n)
Space: O(n)
'''

class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        
        if len(nums) < 3:
            return 0
        
        dp = [0 for _ in range(len(nums))]
        count = 0
        for i in range(len(nums)-3,-1,-1):
            if nums[i+2] - nums[i+1] == nums[i+1] - nums[i]:
                dp[i] = 1 + dp[i+1]
                count += dp[i]
                
        return count


'''
Using DP (first to last) single element
Time: O(n)
Space: O(1)
'''