# Created by Aashish Adhikari at 1:11 PM 3/20/2021

'''
Time Complexity:
O(n)

Space Complexity:
O(n) for the dp table
'''

class Solution(object):

    def numberOfArithmeticSlices(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        if len(nums) < 3:
            return 0


        # dp[i] contains the number of new arithmetic slices that are created because of the element nums[i].
        dp = [0 for idx in range(len(nums))]
        dp[0], dp[1] = 0, 0

        current_diff = nums[1] - nums[0]

        total = 0

        for curr in range(2, len(nums)):

            if nums[curr] - nums[curr-1] == current_diff:

                dp[curr] = dp[curr-1] + 1
            else:
                dp[curr] = 0
                current_diff = nums[curr] - nums[curr-1]


        return sum(dp)


