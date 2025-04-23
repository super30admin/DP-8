# Time Complexity: O(n), single loop through the array
# Space Complexity: O(1), constant space used (no extra dp array)

class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        n = len(nums)
        if n < 3:
            return 0

        count = 0
        prev_count = 0

        for i in range(2, n):
            if nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]:
                prev_count += 1
                count += prev_count
            else:
                prev_count = 0

        return count
