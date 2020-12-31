#Time Complexity : O(n) 
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def numberOfArithmeticSlices(self, A: List[int]) -> int:
        #OPTIMIZED - TC: O(n), SC: O(1)
        if not A:
            return 0
        count = 0
        curr, prev = 0, 0
        for i in range(2, len(A)):
            if A[i] - A[i-1] == A[i-1] - A[i-2]:
                curr = prev+1
                count += curr
                prev = curr
            else:
                prev = 0
        return count


        #OPTIMIZED - TC: O(n), SC: O(n)
        #if not A:
        #   return 0
        #count = 0
        #dp = [0 for _ in range(len(A))]
        #for i in range(2, len(A)):
        #   if A[i] - A[i-1] == A[i-1] - A[i-2]:
        #   dp[i] = dp[i-1]+1
        #   count += dp[i]

        #  return count


        #BRUTE FORCE - TC: O(n^2), SC: O(1)
        # if not A:
        #     return 0
        # count = 0
        # for i in range(len(A)-2):
        #     diff = A[i+1] - A[i]
        #     for j in range(i+1, len(A)-1):
        #         if A[j+1] - A[j] == diff:
        #             count += 1
        #         else:
        #             break
        # return count
