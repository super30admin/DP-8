# Created by Aashish Adhikari at 1:10 PM 3/20/2021

'''
Time Complexity:
O(n^2)

Space Complexity:
O(1)
'''

class Solution(object):


    def numberOfArithmeticSlices(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) < 3:
            return 0

        total_slices = 0


        for i in range(0, len(nums)-2):

            if nums[i+1] - nums[i] == nums[i+2] - nums[i+1]:

                total_slices += 1

                diff = nums[i+1] - nums[i]


                for j in range(i+3, len(nums)):

                    # If the difference matches continue, else, break the inner loop and go to next i.
                    if nums[j] - nums[j-1] == diff:

                        total_slices += 1
                    else:
                        break


        return total_slices


