# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
from typing import List
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        count = 0
        n = len(nums)
        #dp = [0]*n
        curr = 0
        prev = 0

        for i in range(2,n):
            if(nums[i-2]-nums[i-1] == nums[i-1]-nums[i]):
                curr = 1 + prev
                count+=curr
            else:
                curr = 0
            prev = curr
        
        return count