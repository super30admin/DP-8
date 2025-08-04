class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        n=len(nums)
        prev=curr=0
        s=0
        for i in range(n-3,-1,-1):
            cDiff=nums[i]-nums[i+1]
            pDiff=nums[i+1]-nums[i+2]
            if cDiff==pDiff:
                curr=1+prev
                s+=curr
            else:
                curr=0
            
            prev=curr
        
        return s
