'''
time complexity: O(n)
space complexity: O(n)
'''
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [0 for _ in range(n)]
        count = 0
        for i in range(2,n):
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]):
                dp[i-1] = 1 + dp[i-2]
                count = count + dp[i-1]
        return count
        