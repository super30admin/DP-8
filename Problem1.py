# Time complexity : O(n)
# Space complexity : O(1)
# Works on leetcode : Yes
#Approach - We have to have minimum of 3 elements in input array, so whenever we add a new element to the current sequence
# we get len(current seq) - 3 possible combinations added to our answer overall. So we use cur to count the length of current
# sequence and whenever we have +1 to cur, we add len(cur) to the sequence 
class Solution:
    def numberOfArithmeticSlices(self, A: List[int]) -> int:
        cur, summ = 0,0
        for i in range(2,len(A)):
            if A[i]-A[i-1]==A[i-1]-A[i-2]:
                cur += 1
                summ += cur
            else:
                cur=0
        return summ