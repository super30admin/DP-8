# Time Complexity : O(nm)
# Space Complexity : O(size of last row)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach:
# Just like minimum falling path sum: keep running sum for every row(you'd get them from the previous row): for corner elements just add the previous row adjacent element, and for middle elements get the minimum sum of adjacent elements of previous row. At the last row, return minimum of all the sums produced till now.
# Another approach could be going bottom to top and starting from row-1 and go upwards for minimum sum. This would reduce our corner cases that we were calculating each time. min(dp[i+1][j], dp[i+1][j+1])
# Above solution would manipulate the input matrix, if we can't use the input array then you should copy the last row array as that is the max number of elements you'll encounter. We only refer to the sum of elements right below our row. Hence we don't need to maintain a matrix and can make use of the array. So for given example, we use [4,1,8,3] -> [7,6,10,3] -> [9, 10, 10, 3] -> [11, 10, 10, 3] by using dp[j]= min(dp[j], dp[j+1])+get[i][j] and return the answer at first index.

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if triangle == None or len(triangle)==0 or len(triangle[0])==0:
            return 0
        
        dp = [0 for _ in range(len(triangle[len(triangle)-1]))]
        
        #populate last row in dp
        for j in range(len(dp)):
            dp[j] = triangle[len(dp)-1][j]
            
        # fill by dp logic
        for i in range(len(dp)-2, -1, -1):
            for j in range(0, len(triangle[i])):
                dp[j] = min(dp[j], dp[j+1])+ triangle[i][j]
                
        return dp[0]
        