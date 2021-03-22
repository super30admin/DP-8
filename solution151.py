#Time Complexity:O(n)
#Space Complexity:O(1)
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if len(nums)==0:
            return 0
        count=0                                             #variable to hold the count of slices
        prev=0                                              #variable to hold slices at previous number
        for i in range(2,len(nums)):
            if nums[i]-nums[i-1]==nums[i-1]-nums[i-2]:      #if difference between last two numbers are same, increment previous by one and count by previous
                prev=prev+1
                count+=prev
            else:
                prev=0                                      #else assign prev to zero
        return count                                        #return count