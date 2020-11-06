class Solution:
    def numberOfArithmeticSlices(self, A: List[int]) -> int:
        # Time: O(N)
        #Space: O(1)
        if len(A)<3:
            return 0
        sol=0
        curr_length=1
        curr_diff=0
        for i in range(1,len(A)):
            if A[i]-A[i-1]==curr_diff:
                curr_length+=1
                if curr_length>=3:
                    sol+=(curr_length-2)
            else:
                curr_diff=A[i]-A[i-1]
                curr_length=2
        return sol
            