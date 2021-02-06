class Solution(object):
    def numberOfArithmeticSlices(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
#         #2pointer>creating partitions of equal diff
#         #O(n2)
#         if not A or len(A)<3:
#             return 0
#         count=0
#         for i in range(len(A)-2):
#             diff=A[i+1]-A[i]
#             for j in range(i+1,len(A)-1):
#                 if A[j+1]-A[j]==diff:
#                     count+=1
#                 else:
#                     break
#         return count
        
#         #DP
#         #O(n)> both
#         if not A or len(A)<3:
#             return 0
#         count=0
#         dp=[0]*len(A)
#         for i in range(2,len(A)):
#             if A[i]-A[i-1]==A[i-1]-A[i-2]:
#                 dp[i]=1+dp[i-1]
#                 count+=dp[i]
#         return count
        #dp
        #O(n)
        #O(1)
        #just take care of previous diff value
        if not A or len(A)<3:
            return 0
        count=0
        prev=0
        cur=0
        for i in range(2,len(A)):
            if A[i]-A[i-1]==A[i-1]-A[i-2]:
                cur=prev+1
                count+=cur
                prev=cur
            else:
                #if mismatch>reset prev to zero
                prev=0
        return count
    