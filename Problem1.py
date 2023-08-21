#Time Complexity is O(n) where n is the length of the nums array
#Space complxity is O(n) where n is the length of the nums array
#No issues faced while coding
#Code ran successfully on leetcode
class Solution(object):
    def numberOfArithmeticSlices(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #base condition
        if(nums==None or len(nums)==0):
            return 0
        #Initializing the required variables
        n=len(nums)
        result=0
        #Creating a DP array
        dp=[0 for i in range(0,n)]
        #Iterating through the ums array in reverese direvtion
        for i in range(n-3,-1,-1):
            #If the below condition satisfies, we will increase the number of
            #arithmetic slices by 1
            if(nums[i]-nums[i+1]==nums[i+1]-nums[i+2]):
                dp[i]=dp[i+1]+1
            #FInally we are adding the value in the dp array at that particular idex to result
            result+=dp[i]
        #Finally we will return result
        return result