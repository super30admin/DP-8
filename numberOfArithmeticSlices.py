# TimeComplexiyty:O(n)
# SpaceComplexity:O(1) if we use 2 variable one for running ans and other for global ans O(n) for DP
# Appraoch: Use for loop for brute force fix pointer and move other pointer and check differnce
# Optimal: 
# [16,17,18,19,20] lets consider this 
# for 16->3
#     17->2 but we are cheking for almost same triplets rioght like diff should be same so we can use 17's result to 16 or viceversa
                                                                       



#------------------
#Optimal
#------------------
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        #brute force serach for 2 differnce
        ans=0
        if len(nums)<3:return 0
        dp=[0 for _ in range(len(nums))]
        if nums[1]-nums[0]==nums[2]-nums[1]:dp[2]=1
        
        for i in range(3,len(nums)):
            if nums[i]-nums[i-1]==nums[i-1]-nums[i-2]:
                dp[i]=dp[i-1]+1
        return sum(dp)
#------------------
#BrtueForce
#------------------
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        #brute force serach for 2 differnce
        ans=0
        for i in range(len(nums)-2):
            diff= nums[i+1]-nums[i]
            for j in range(i+2,len(nums)):
                if nums[j]-nums[j-1]==diff:
                    ans+=1
                else:break
        return ans
