class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        # brute force
        # n = len(nums)
        # count=0
        # for i in range(n-2):
        #     for j in range(i+2,n):
        #         if (nums[j]-nums[j-1])==(nums[j-1]-nums[j-2]):
        #             count+=1
        #         else:
        #             break
        # return count
        # time complexity is n^2
        n = len(nums)
        if n < 3:
            return 0

        dp = [0] * n
        count = 0

        for i in range(2, n):
            if nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]:
                dp[i] = dp[i - 1] + 1
                count += dp[i]

        return count

    # #time complexity is O(n)
    # #space complexity is O(n)