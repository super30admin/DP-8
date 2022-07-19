# Time Complexity : O(N*N) where N is length of the nums array
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        count = 0
        for i in range(len(nums)-2):
            diff = nums[i+1] - nums[i]
            for j in range(i+2, len(nums)):
                if nums[j] - nums[j-1] == diff:
                    count += 1
                else:
                    break      
        return count