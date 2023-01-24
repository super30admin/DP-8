# Time Complexity : O(n), Where n is number of elments in the nums array
# Space Complexity : O(n), Where n is number of elements in the nums array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

from typing import List

class Solution:
    def solution(self,index,nums,memo):
        #Base Case
        if(index>=len(nums)-2):
            return 0
        if(memo[index]!=None):
            return memo[index]
        
        #Actual logic
        if(nums[index+1] - nums[index] == nums[index+2] - nums[index+1]):
            #case1, we can form a pair of three
            length,count=3,1
            diff=nums[index+1] - nums[index]
            i=index+2
            while(i<len(nums)-1):
                if(nums[i+1]-nums[i]==diff):
                    length+=1
                    count+=(length-2)
                else:
                    break
                i+=1
            
            memo[index]=count+self.solution(i,nums,memo)
            
        else:
            #case2
            memo[index]=0+self.solution(index+1,nums,memo)
        return memo[index]
        
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        dp=[None for i in range(len(nums))]
        return self.solution(0,nums,dp)
        