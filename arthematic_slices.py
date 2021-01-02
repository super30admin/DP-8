class Solution:
    def numberOfArithmeticSlices(self, A: List[int]) -> int:
        ##time -O(n**2)
        ##space-O(1)
        #         count=0

        #         for i in range(len(A)-2):
        #             for j in range(i+1,len(A)-1):
        #                 if A[i+1]-A[i]==A[j+1]-A[j]:
        #                     count+=1
        #                 else:
        #                     break
        #         return count

        ##time-O(n)
        ##space-O(n)
        ##des- maintain an array with the number of possible arthematic slices and add em up to count
        # count=0
        # dp=[0]*len(A)
        # for i in range(2,len(A)):
        #     if A[i-1]-A[i]==A[i-2]-A[i-1]:
        #         dp[i]=dp[i-1]+1
        #         count+=dp[i]
        #     # else:
        #     #     break
        # return count

        ########## 2 -pointer- memoization ##########
        ##time-O(n)
        # space-O(1)
        ##des- instead of maintaining an array maintain curr and prev for the number of possible arthematic slices and add em up to count
        count = 0
        curr = prev = 0
        for i in range(2, len(A)):
            if A[i - 1] - A[i] == A[i - 2] - A[i - 1]:
                curr = prev + 1
                count += curr
                prev = curr
            else:
                prev = 0
        return count