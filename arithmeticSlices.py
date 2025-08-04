"""
Let dp[i] be the number of arithmetic slices ending at index i
If nums[i] - nums[i-1] == nums[i-1] - nums[i-2], then dp[i] = dp[i-1] + 1
The total number of slices is the sum of all dp[i]
"""
"""
Time Complexity: O(n) - Traverse nums array
Space Complexity: O(n) - Dp array
"""

class arithmeticSlices:
    def numberOfArithmeticSlices(self, nums: list[int]) -> int:
        n = len(nums)
        if n < 3:
            return 0

        dp = [0] * n
        total = 0

        for i in range(2, n):
            if nums[i] - nums[i-1] == nums[i-1] - nums[i-2]:
                dp[i] = dp[i-1] + 1
                total += dp[i]

        return total


if __name__ == "__main__":
    obj = arithmeticSlices()
    print(obj.numberOfArithmeticSlices([1, 2, 3, 4]))            # 3
    print(obj.numberOfArithmeticSlices([1, 3, 5, 7, 9]))          # 6
    print(obj.numberOfArithmeticSlices([7, 7, 7, 7]))             # 3
    print(obj.numberOfArithmeticSlices([3, -1, -5, -9]))          # 6
