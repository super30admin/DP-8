class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        # T: O(n), S: O(1)
        n = len(nums)
        if n < 3:
            return 0

        count = 0
        curr = 0  # Current number of arithmetic slices ending at index i

        for i in range(2, n):
            if nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]:
                curr += 1
                count += curr  # Add all slices ending at index i
            else:
                curr = 0  # Reset if sequence breaks

        return count
