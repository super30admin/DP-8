class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        """
            Time complexity: O(n^2)
            Space complexity: O(1)
            Approach:
                - We go bottom up starting from the second last row and add 
                the min of ith and i+1th index to the current sum
                - In the end we return the top of the pyramid i.e. triangle[0][0]
        """

    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle)
        for i in range(n-2, -1, -1):
            for j in range(0, len(triangle[i])):
                triangle[i][j] += min(triangle[i+1][j], triangle[i+1][j+1])
        return triangle[0][0]

        # n = len(triangle)
        # for i in range(1, n):
        #     for j in range(0, len(triangle[i])):
        #         if j-1 < 0:
        #             triangle[i][j] += triangle[i-1][j]
        #         elif j == len(triangle[i-1]):
        #             triangle[i][j] += triangle[i-1][j-1]
        #         else:
        #             triangle[i][j] += min(triangle[i-1][j-1], triangle[i-1][j])
        # min1 = float('inf')
        # for i in triangle[n-1]:
        #     min1 = min(min1, i)
        # return min1
