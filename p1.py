#Time: O(n)
#Space: O(1)
class Solution:
    def numberOfArithmeticSlices(self, A: List[int]) -> int:
        cur, summ = 0,0
        prev =0
        for i in range(2,len(A)):
            if A[i]-A[i-1]==A[i-1]-A[i-2]:
                cur = prev+1
                summ += cur
                prev=cur
            else:
                prev=0
        return summ 
