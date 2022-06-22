#Arithmetic Slices

# // Time Complexity : O(N)
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        dp=[0]*(len(nums))
        if(len(nums)<3): return 0
        i=2
        sums=0
        while(i<len(nums)):
            if (nums[i]-nums[i-1] == nums[i-1]-nums[i-2]):          #if the difference between previous two elements are same, then increment the value plus the previous one
                dp[i] = dp[i-1]+1
                sums+= dp[i]
            i+=1
        return sums
        