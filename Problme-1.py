class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if not nums or len(nums)<3:
            return 0
        prev=0
        running_sum=0
        p1=len(nums)-3
        
        while p1>=0:
            if nums[p1+2]-nums[p1+1]==nums[p1+1]-nums[p1]:
                prev+=1
                running_sum+=prev
            else:
                prev=0
            p1-=1
                
        return running_sum
        