class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        #Optimization: TC:O(n), SC: O(n)
        n = len(nums)
        dp = [0] * n
        i = 0
        count = 0
        for i in range(i+2,n):
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]):
                dp[i] = dp[i-1] + 1
                count += dp[i]
        return count

        #Brute Force TC: O(n*2), SC: O(1)
        n = len(nums)
        count = 0
        for i in range(0,n-2):
            for j in range(i+2, n):
                #If the difference is equal then increment the count
                if(nums[j]-nums[j-1]==nums[j-1]-nums[j-2]):
                    count += 1
                #Else break the inner loop, i.e, outerloop executes again
                else:
                    break
        return count
        