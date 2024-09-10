// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

//Using bottom up - tabulation - optimising space
class Triangle {

    // top down using recursion
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(triangle, 0, 0, dp);
    }

    private int helper(List<List<Integer>> triangle, int i, int j, int[][] dp) {
        // base
        if (i == triangle.size())
            return 0;
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        // logic
        // fall to jth index
        int case1 = helper(triangle, i + 1, j, dp);
        // fall to j+1th index
        int case2 = helper(triangle, i + 1, j + 1, dp);
        dp[i][j] = triangle.get(i).get(j) + Math.min(case1, case2);
        return dp[i][j];
    }
}