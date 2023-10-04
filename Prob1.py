class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        #Method 1 - Brute Force - TC O(n^2)
        # n=len(nums)
        # count=0
        # for i in range(n-1):
        #     for j in range(i+2,n):
        #         diff=nums[i+1]-nums[i]
        #         if nums[j-1]-nums[j-2]==nums[j]-nums[j-1]:
        #             count+=1
        #         else:
        #             break
        # return count
        
        #Method 2 - DP - 1D - TC and SC O(n)
        # n=len(nums)
        # dp=[0 for _ in range(n+1)]
        # for i in range(2,n):
        #     if nums[i]-nums[i-1]==nums[i-1]-nums[i-2]:
        #         dp[i]=dp[i-1]+1
        # return sum(dp)
        #Method 3 - DP with 2 variables - TC O(n) and SC O(1)
        n=len(nums)
        prev=0
        curr=0
        count=0
        for i in range(2,n):
            if nums[i]-nums[i-1]==nums[i-1]-nums[i-2]:
                curr=prev+1
                count+=curr
            else:
                curr=0
            prev=curr
        return count