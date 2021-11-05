# // Time Complexity :O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach


class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        dp=[0 for i in range(len(nums))]
        count=0
        curr=0
        for i in range(2,len(nums)):
            if nums[i]-nums[i-1] == nums[i-1]-nums[i-2]:
                curr=curr+1
            else:
                curr=0
            count+=curr
            print(count)
        return count
            