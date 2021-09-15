#Space:O(n)
#Time:O(n)
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if len(nums)<3:
            return 0
        dp_array = [0]*len(nums)
        for i in range(2,len(nums)):
            if nums[i-1]-nums[i-2]==nums[i]-nums[i-1]:
                dp_array[i]=dp_array[i-1]+1
        return sum(dp_array)