#time: O(n)
#space: O(n)

class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        
        if len(nums) <=1:
            return 0
        prev=0
        cnt=0
        for i in range(2,len(nums)):
            if (nums[i] - nums[i-1]) == (nums[i-1] - nums[i-2]):
                prev+=1
                cnt+=prev
            else:
                prev=0
        return cnt
