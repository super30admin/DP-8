class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        '''
        Two Pointer Solution
        Time: O(n)
        Space: O(1)
        '''
        if(len(nums)<3):
            return 0
        i=0
        j=1
        o = 0
        while(j<len(nums)):
            diff = nums[j]-nums[i]
            c=1
            while(j<len(nums) and nums[j]-nums[i]==diff):
                c+=1
                i+=1
                j+=1
            if(c>2):
                # sum of count (n*n+1)//2
                o += (c-2)*(c-1)//2
        return o
