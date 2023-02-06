#time complexity:O(n)
#space complexity: O(n)
#ran on leetcode: yes
#maintain a dp array to calculte the number of slices seen so far. Sum the array after traversing through the input.
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        L=[0]*len(nums)
        for i in range(2,len(nums)):
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]):
                L[i]=L[i-1]+1
        return sum(L)
