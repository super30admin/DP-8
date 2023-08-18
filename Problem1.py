class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        '''
        Count the number of arithmetic slices of length 3 or more in the given list.

        :param nums: List of integers
        :return: Number of arithmetic slices

        Time Complexity: O(N), where N is the number of elements in the input list.
        We iterate through the list once to calculate the number of arithmetic slices.

        Space Complexity: O(1), as we only use a constant amount of extra space to store variables.
        '''
        n = len(nums)
        if n < 3:
            return 0

        total_slices = 0        # Initialize the counter for total arithmetic slices
        current_slices = 0      # Initialize the counter for current consecutive slices

        # Iterate through the list starting from the third element
        for i in range(2, n):
            if nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]:
                current_slices += 1  # Increment the current slice counter
                total_slices += current_slices  # Add the current slices to the total
            else:
                current_slices = 0  # Reset the current slice counter if no longer consecutive

        return total_slices
