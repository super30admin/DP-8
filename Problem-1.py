#Time Complexity :o(n)
#Space Complexity :o(1)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no
class Solution(object):
    def numberOfArithmeticSlices(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if(len(nums)<3):
            return 0
        
        prev=0
        maxi=0
        for i in range(2,len(nums)):
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]):
                prev+=1
                maxi+=prev
            else:
                prev=0
        return maxi