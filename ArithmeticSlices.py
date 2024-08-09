# Time Complexity : O(n)
# Space Complexity : O(1)
class Solution:
    def numberOfArithmeticSlices(self, nums: list[int]) -> int:
        if not nums or len(nums) < 3:
            return 0
        
        n = len(nums)
        count = 0
        cur = 0
        
        for i in range(2, n):
            if nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]:
                cur += 1
                count += cur
            else:
                cur = 0

        return count

# Examples

# Example 1
solution = Solution()
result = solution.numberOfArithmeticSlices([1, 2, 3, 4])
print(result)  # Output: 3

# Example 2
solution = Solution()
result = solution.numberOfArithmeticSlices([1, 3, 5, 7, 9])
print(result)  # Output: 6

# Example 3
solution = Solution()
result = solution.numberOfArithmeticSlices([7, 7, 7, 7])
print(result)  # Output: 3