"""
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : no

Here, the bruteforce would be to take a 2 pointer or a sliding window approach. There, we would start from the beginning and keep
track of the difference, if its is same after length of three, we will keep on incrementing our count. Once the difference
changes, we need to increment our first pointer and start the whole operation again. This is an n^2 solution. To optimize this,
we can see that while the first pass, we are already calculating the difference, then why do we need to increment the first pointer
and perform all those calculations all over again. So, we maintain a DP array, where we can store the number of slices possible
till that point of time. We start from 2nd index and keep on checking if the last 2 values have same difference as well. If yes, we 
are inside a slice, so we just need to incremnt the counter by 1 and add the previous counter to it (already computed slices).
This solution (commented) can also be optimised as we donot need a DP array. We are only taking into account the previous value.
So we would just maintain a prev and curr variable for calcul;ation.
"""


class Solution:
    def numberOfArithmeticSlices(self, A: List[int]) -> int:
        if not A:
            return 0
        l = len(A)
        sum_ = 0
        prev, curr = 0, 0
        for i in range(2, l):
            if A[i]-A[i-1] == A[i-1]-A[i-2]:
                curr = 1+prev
                sum_ += curr
                prev = curr
            else:
                prev = 0
        return(sum_)
    # def numberOfArithmeticSlices(self, A: List[int]) -> int:
    #     if not A:
    #         return 0
    #     l=len(A)
    #     dp=[0 for i in range(l)]
    #     sum_=0
    #     for i in range(2,l):
    #         if A[i]-A[i-1]==A[i-1]-A[i-2]:
    #             dp[i]=1+dp[i-1]
    #         sum_+=dp[i]
    #     return(sum_)
