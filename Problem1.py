#Time Complexity :O(n)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        prev=0
        res=0
        for i in range(len(nums)-3,-1,-1):
            if nums[i+1]-nums[i]==nums[i+2]-nums[i+1]:
                prev+=1
            else:
                prev=0
            res+=prev
        return res

        