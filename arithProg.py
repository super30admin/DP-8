# As taught in class, using DP to solve this problem, which means increase count onlyif the difference between the next nd prev elements is maintained
#Time complexity: O(n)
#Space complexity: O(1)
class Solution:
    def numberOfArithmeticSlices(self, A: List[int]) -> int:
        if A is None or len(A)<3:
            return 0
        count = 0
        for i in range(len(A)-2):
            diff = A[i+1] - A[i]
            for j in range(i+1,len(A)-1):
                if A[j+1] - A[j] == diff:
                    count = count + 1
                else:
                    break
        return count