#Time Complexity : O(N^2) where N is the Number of elements in A
#Space Complexity : O(1) 
class Solution:
    def numberOfArithmeticSlices(self, A: List[int]) -> int:
        if len(A) <3:
            return 0
        count = 0
        for i in range(len(A)-2):
            diff = A[i+1] - A[i]
            for j in range(i+2,len(A)):
                if A[j] - A[j-1] == diff:
                    count+=1
                else:
                    break
        return count
=====================================================================================================
#Time Complexity : O(N) where N is the Number of elements in A
#Space Complexity : O(N) 
class Solution:
    def numberOfArithmeticSlices(self, A: List[int]) -> int:
        if len(A) <3:
            return 0
        dp = [0 for x in range(len(A))]
        sum1 = 0
        for i in range((len(A) -3),-1,-1):
            if (A[i+1] -A[i]) == (A[i+2] - A[i+1]):
                dp[i] = dp[i+1]+1
                sum1+=dp[i]
        return sum1
 ========================================================================================================
#Time Complexity : O(N) where N is the Number of elements in A
#Space Complexity : O(1s)    
class Solution:
    def numberOfArithmeticSlices(self, A: List[int]) -> int:
        if len(A) <3:
            return 0
        right = 0
        sum1 = 0
        for i in range((len(A) -3),-1,-1):
            if (A[i+1] -A[i]) == (A[i+2] - A[i+1]):
                right +=1
                sum1+=right   
            else:
                right = 0
        return sum1