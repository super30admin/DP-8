# O(n) time, O(n) space
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        T = [0]*len(nums)
        sum=0
        for i in range(2,len(nums)):
            if nums[i]-nums[i-1]==nums[i-1]-nums[i-2]:
                T[i]=1+T[i-1]
                sum+=T[i]
        return sum