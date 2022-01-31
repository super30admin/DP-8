from typing import List
# Brute Force Solution
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0 or len(nums) < 3:
            return 0
        n = len(nums)
        count = 0
        for i in range(n-2):
            diff = nums[i+1] - nums[i]
            for j in range(i+1, n-1):
                if nums[j+1] - nums[j] == diff:
                    count +=1
                else:
                    break
        return count
        
# Time Complexity : O(n^2)
# Space Complexity: O(1)



# Dynamic Programming Solution
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0 or len(nums) < 3:
            return 0
        n = len(nums)
        result = 0
        dp = [0] * n
        for i in range(2, n):
            if nums[i] - nums[i-1] == nums[i-1] - nums[i-2]:
                dp[i] = dp[i-1] + 1
                result += dp[i]
            
        return result

# Time Complexity : O(n)
# Space Complexity: O(n)


class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0 or len(nums) < 3:
            return 0
        n = len(nums)
        result = 0
        prev, curr = 0, 0
        for i in range(2, n):
            if nums[i] - nums[i-1] == nums[i-1] - nums[i-2]:
                curr = prev + 1
                result += curr
                prev = curr
            else:
                prev = 0
            
        return result

# Time Complexity : O(n)
# Space Complexity: O(1)