'''
    Time Complexity: O(n)
    Space Complexity: O(1)
'''
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        n = len(nums)
        result = 0

        if n < 3:
            return result

        prev = 0
        curr = 0

        for i in range(2, n):
            if nums[i] - nums[i-1] == nums[i-1] - nums[i-2]:
                curr = prev + 1
            else:
                curr = 0
            
            result += curr
            prev = curr

        return result