"""
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
Given below
"""
class Solution:
    def numberOfArithmeticSlices(self, A: List[int]) -> int:
        """
        Method1 - Brute Force - Time - O(N2), Space - O(1)
        Idea is to contsider every possible sublist(with same difference between consec elements) starting with each element in the array
        With every different difference than current difference, break the inner loop
        
        eg 1,3,5,7,9,15,20,25,28,29
        
        Method2 - DP space suboptimal Time - O(n), Space - O(n)
        Idea is if we start from the right the number of arithmetic subsets at a given index would be based on the counts computed already on the right if it would have the same difference
        Return the sum of the value in dp array
        [1,3,5,7,9]
        0,0,0,0,0
        
        Method3 - DP space optimal - O(1) space
        Idea is to use the DP space based approach with same checks, but regulated by the single count pointer called as right, resetting the pointer for every non matchable difference
        
        """
        count = 0
        for i in range(len(A)-2):
            j = i + 1
            current_diff = A[j] - A[i]
            j+=1
            while j < len(A) and A[j] - A[j-1] == current_diff:
                count+=1
                j+=1
        return count
    
        #DP solution - Space - suboptimal
        dp = [0]*len(A)
        for i in range(len(A)-3,-1,-1):
            if A[i+2] - A[i+1] == A[i+1] - A[i]:
                dp[i] = dp[i+1] + 1
        return sum(dp)
    
        #DP - Space optimal
        right = 0
        sm = 0
        for i in range(len(A)-3,-1,-1):
            #considering triplet atleast for checking for difference
            if A[i+2] - A[i+1] == A[i+1] - A[i]:
                right+=1
                sm +=right
            else:
                right = 0
        return sm