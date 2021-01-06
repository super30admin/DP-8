"""
Time complexity O(N)
Space complexity O(1)


"""


class Solution:
    def numberOfArithmeticSlices(self, A: List[int]) -> int:
        if not A or len(A)<3:
            return 0
        dp=[0]*len(A)
        sum1=0
        curr=0
        prev=0
        for i in range(2,len(A)):#start from idx 2 
            if(A[i]-A[i-1]==A[i-1]-A[i-2]): #calculate difference
                curr=prev+1 #dp 
                sum1+=curr#no of slices running sum
                prev=curr
            else:
                prev=0
                
        return sum1 