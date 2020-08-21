# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

# Method 1) Brute Force 
# Tc = O(n^2) | Sc = O(1)
# class Solution:
#     def numberOfArithmeticSlices(self, A):
#         if len(A) == 0 or len(A) < 3:
#             return 0 
#         count = 0 
#         i = 0 
#         while i < len(A)-2 : 
#             j = i+1 
            
#             while j < len(A) -1 :
#                 if A[j] - A[j-1] == A[j+1] - A[j]:
#                     count += 1 
#                     j += 1
#                 else:
#                     break 
            
#             i += 1 
        
#         return count 

# Method-2) DP 
# Tc = O(n) | Sc = O(n)
# class Solution:
#     def numberOfArithmeticSlices(self, A):
#         if len(A) == 0 or len(A) < 3:
#             return 0 
#         dp = [0 for _ in range(len(A))]
#         count = 0 
#         for i in range(len(A)-3, -1, -1):
#             if A[i+1] - A[i] == A[i+2] - A[i+1]:
#                 dp[i] = dp[i+1] + 1 
#                 count += dp[i]
        
#         return count


# Method-3) DP optimized with Sc as O(1)
# Tc = O(n) | Sc = O(1)
class Solution:
    def numberOfArithmeticSlices(self, A):
        if len(A) == 0 or len(A) < 3:
            return 0 
        dp = [0 for _ in range(len(A))]
        count = 0 
        prev = 0 
        for i in range(len(A)-3, -1, -1):
            if A[i+1] - A[i] == A[i+2] - A[i+1]:
                prev = prev + 1 
            else:
                prev = 0 
            
            count += prev
        
        return count


if __name__ == "__main__":
    s = Solution()
    res = s.numberOfArithmeticSlices([1,2,3,8,9,10])
    assert res == 2