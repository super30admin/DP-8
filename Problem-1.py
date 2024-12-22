#Approach

#find the diffrence between the i-1, i+1 if iti is ame increase the count


#Complexities
#Time: O(n)
#Sapce: O(1)

from typing import List


class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        result =0
        curr=0
        for i in range(2,len(nums)):

            if nums[i]-nums[i-1] == nums[i-1]-nums[i-2]:
                curr= curr+1
                result+=curr
            else:
                curr=0
        return result

