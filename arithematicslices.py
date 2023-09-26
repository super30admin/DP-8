class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        count = 0 # Initialize a counter for the number of arithmetic slices
        curr = 0 # Initialize a variable for the current length of the arithmetic slice
        
        for i in range(2, len(nums)):
            if nums[i] - nums[i-1] == nums[i-1] - nums[i-2]:
                curr += 1 # Increase the current length of the arithmetic slice
                count += curr # Add the current length to the total count of arithmetic slices
            else:
                curr = 0 # Reset the current length to 0 if the slice is not arithmetic
        
        return count # Return the total count of arithmetic slices