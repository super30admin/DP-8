'''
Accepted on leetcode(413)
time - O(N)
space - O(1)
Recursive approach.
'''
class Solution:
    def __init__(self):
        # global variable to keep track of number of slices.
        self.slices = 0

    def numberOfArithmeticSlices(self, A) -> int:
        self.makeSlices(A, 0)
        return self.slices

    def makeSlices(self, A, i):
        # base case: consider more than 2 elements
        if i >= len(A) - 2:
            return 0

        temp = 0  # return from recursion
        if A[i + 1] - A[i] == A[i + 2] - A[i + 1]:  # if diff. is same - arithmatic slice
            temp = 1 + self.makeSlices(A, i + 1)  # add one and call recursion
            self.slices += temp  # add all the arithmatic slices to return final result.
        else:
            self.makeSlices(A, i + 1)  # not an arithmatic slice return 0
        return temp


'''
Accepted on leetcode(413)
time - O(N)
space - O(1)
DP Array approach.
'''
class Solution1:
    def __init__(self):
        self.slices = 0

    def numberOfArithmeticSlices(self, A) -> int:
        dp = [0 for i in range(len(A))]

        for i in range(len(A) - 3, -1, -1):
            if A[i + 1] - A[i] == A[i + 2] - A[i + 1]:
                dp[i] = 1 + dp[i + 1]
                self.slices += dp[i]
        return self.slices


'''
Accepted on leetcode(413)
time - O(N)
space - O(1)
DP as next variable(tracking next value) approach.
'''
class Solution2:
    def __init__(self):
        self.slices = 0

    def numberOfArithmeticSlices(self, A: List[int]) -> int:
        dp = 0  # dp is just an iterator variable tracking next value.
        for i in range(len(A) - 3, -1, -1):

            if A[i + 1] - A[i] == A[i + 2] - A[i + 1]:
                dp = 1 + dp
                self.slices += dp
            else:
                # if some range is not arithmatic slice make dp '0' so that next value is 0.
                dp = 0
        return self.slices