"""
Time complexity O(N)
Space complexity O(N)


"""


class Solution:
    def numberOfArithmeticSlices(self, A: List[int]) -> int:
        if not A or len(A)<3:
            return 0
        dp=[0]*len(A)
        sum1=0
        for i in range(2,len(A)):#start from idx 2 
            if(A[i]-A[i-1]==A[i-1]-A[i-2]): #calculate difference
                dp[i]=dp[i-1]+1 #dp curr=prev+1
                sum1+=dp[i] #no of slices running sum
        return sum1 