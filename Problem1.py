#Time Complexity : O(N)
#Space Complexity: O(N)
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        li = [0] * len(nums)
        summ = 0
        for i in range(2,len(nums)):
            if nums[i] - nums[i-1] == nums[i-1] - nums[i-2]:
                li[i] = li[i-1] + 1
                summ += li[i]
        return summ
            
                