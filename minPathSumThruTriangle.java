// Time Complexity : O(n(n+1)/2) where n is the length of the arraylist triangle
// Space Complexity : O(n^2) where n is the length of the arraylist triangle
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// In this question, an adjacent number is defined as that index and the next index, not the previous index

class minPathSumThruTriangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0) return 0;
        int[][] dp = new int[n+1][n+1];
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
}