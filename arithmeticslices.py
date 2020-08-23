# Without using dp array
# Time complexity - O(n)
# Space complexity - O(1)
# Did this solution run on leetcode? - yes
class Solution:
    def numberOfArithmeticSlices(self, A: List[int]) -> int:
        n = len(A)
        
        tsum = 0
        i=1
        while i<n-1:
            prev = A[i]-A[i-1]
            j=i+1
            rsum = 0
            # only if the difference between 3 consecutive numbers are the same, increment the count.
            while j<n:
                if A[j]-A[j-1] == prev: # if the difference between the two numbers is the same as the previous. 
                    rsum += 1
                    tsum += rsum    # increment the overall count
                    j+=1
                else:
                    break
            i=j
        
        return tsum
            

# Without using dp array
# Time complexity - O(n)
# Space complexity - O(n) 
# Did this solution run on leetcode? - yes
class Solution:
    def numberOfArithmeticSlices(self, A: List[int]) -> int:
        n = len(A)
        dp = [0 for _ in range(n)]
        
        for i in range(1, n-1): 
            if A[i]-A[i-1] == A[i+1]-A[i]: # check every three consecutive numbers
                dp[i+1] = dp[i]+1
        
        return sum(dp)
        