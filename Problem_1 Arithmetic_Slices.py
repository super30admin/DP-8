# // Time Complexity : O(n^2)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :
#
#
# // Your code here along with comments explaining your approach
#Brute Force
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if triangle == None or len(triangle) == 0 or len(triangle[0]) == 0:
            return 0
        n = len(triangle)
        dp = [[0] for i in range(n)]
        for i in range(n):
            dp[i] = triangle[n - 1][i]
        for i in range(n - 2, -1, -1):
            for j in range(i + 1):
                dp[j] = triangle[i][j] + min(dp[j], dp[j + 1])
            print(dp[i])
        return dp[0]

# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :
#
#
# // Your code here along with comments explaining your approach
#Brute Force
# Top Down Approach
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return 0
        sum_v = 0
        n = len(nums)
        dp = [0 for i in range(n)]
        for i in range(2, n):
            if nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]:
                dp[i] = dp[i - 1] + 1
                sum_v += dp[i]
        return sum_v

# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :
#
#
# // Your code here along with comments explaining your approach
#Brute Force
# Top Down Approach Optimized
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return 0
        sum_v = 0
        curr = 0
        prev = 0
        n = len(nums)
        for i in range(2, n):
            if nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]:
                curr = prev + 1
                sum_v += curr
                prev = curr
            else:
                prev = 0
        return sum_v


# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :
#
#
# // Your code here along with comments explaining your approach
#Brute Force
#Bottom Up  Approach
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return 0
        sum_v = 0
        n = len(nums)
        dp = [0 for i in range(n)]
        for i in range(n-3,-1,-1):
            if nums[i+2] - nums[i+1] == nums[i+1] - nums[i]:
                dp[i] = dp[i+1] +1
                sum_v += dp[i]
        return sum_v