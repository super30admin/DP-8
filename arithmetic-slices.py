# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution(object):
    def numberOfArithmeticSlices(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        # Initialize prev and running sum
        # Prev keeps track of number of numbers in a slice
        prev = 0
        sum = 0
        for i in range(2, len(A)):
            # If 3 numbers form an AP, add one to prev
            # sum is the total number of slices
            if A[i] - A[i-1] == A[i-1] - A[i-2]:
                prev = prev + 1
                sum += prev
            else: # Reset prev to 0
                prev = 0
        return sum