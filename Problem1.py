class Solution(object):
    def numberOfArithmeticSlices(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        
        n = len(A)
        
        if n < 3:
            return 0
        #dp = [0] * len(A)
        prev = 0 #keeps track of valid APs at all points
        s = 0
        for i in range(2, n): #valid AP has to be of at least length 3, thats why we start from 2
            if A[i - 1] - A[i - 2] == A[i] - A[i - 1]: #check if common difference is holding
                prev = prev + 1#dp[i] = 1 + dp[i - 1] # add 1 to prev
                s += prev #add to total number APs
            else:
                prev = 0 #if AP breaks, reset prev to 0
                
        return s#sum(dp)