'''
Brute Force:
Time Complexity: O(n^2)
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Explanation: Choose 2 indexes, first one for i and one for j, j moves from i to end of array finding all arithmetic sequences
as it moves.

Linear Solution
Time Complexity: O(n)
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Explanation: If we have 3 elements say 2 4 8 the difference between 4 and 8 should be same as difference between 2 and 4
then they are in a arithmetic sequence hence start from the end-3 (as minimum has to be 3 numbers) and keep moving backwards
if A[i + 1] - A[i] == A[i + 2] - A[i + 1], if this is true then the difference is the same and we increase our current pointer
by 1+ right (similar to running sum) and make right = current (current value which becomes previous for next iteration) this
is needed to keep increasing the current based on if the previous element was in the arithmetic sequence. If the previous
element was in the arithmetic sequence then it will be >=1 else it would be 0. Increase count whenever we see there is a
difference and it will be an increase with the current running sum.
'''


class Solution:
    def numberOfArithmeticSlices(self, A: List[int]) -> int:

        # no need of output
        # output = [0 for i in range(0,len(A))]
        count = 0
        right = 0
        for i in range(len(A) - 3, -1, -1):
            if A[i + 1] - A[i] == A[i + 2] - A[i + 1]:
                current = 1 + right
                count += current
                right = current
            else:
                right = 0

                # output[i] = 1+output[i+1]
                # count += output[i]

        return count

    # Bruteforce
    def numberOfArithmeticSlicesBruteForce(self, A: List[int]) -> int:
        count = 0
        for i in range(0, len(A) - 1):
            diff = A[i + 1] - A[i]
            for j in range(i + 1, len(A) - 1):
                if A[j + 1] - A[j] == diff:
                    count += 1
                else:
                    break

        return count