# Time complexity : O(n*n)
# Space complexity : O(1)
# Leetcode : Solved and submitted

class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        # check for null case
        if not nums or len(nums) == 0:
            return 0
        
        # find length of nums and declare count as 0
        n = len(nums)
        count = 0
        
        # traverse the i th index from 0 till the 3rd last element
        for i in range(n-2):
            # find the difference between i and i+1 element
            diff1 = nums[i+1] - nums[i]
            
            # start the other for loop from i+1 and traverse till the 2nd last element
            for j in range(i+1,n-1):
                # find difference between j and j+1 th index
                diff2 = nums[j+1] - nums[j]
                
                # if the differences match, that means it is an arithmetic slice
                if diff1 == diff2:
                    # increment the count
                    count += 1
                else:
                    # otherwise break the chain and start with the new slice
                    break
        # return the total count of the slices in the array
        return count
