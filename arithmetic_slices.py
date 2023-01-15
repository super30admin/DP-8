class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:

        ## Approach 1: without dp array
        ## T.C = O(n)
        ## S.C = O(1)

        n = len(nums)
        sm = 0
        prev = 0

        for i in range(n-3, -1, -1):
            if nums[i+2] - nums[i+1] == nums[i+1] - nums[i]:
                curr = prev + 1
                prev = curr
                sm += curr
            else:
                prev = 0
        
        return sm

        ## Approach 1: dp array
        ## T.C = O(n)
        ## S.C = O(n)

        n = len(nums)
        dp = [0]*n
        sm = 0

        for i in range(n-3, -1, -1):
            if nums[i+2] - nums[i+1] == nums[i+1] - nums[i]:
                dp[i] = dp[i+1] + 1
                sm += dp[i]
        
        return sm