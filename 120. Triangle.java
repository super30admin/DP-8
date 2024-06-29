// Time Complexity : O(n * m)
// Space Complexity : O(n * n)
// Method used : DP

class Solution {

    int[][] dp;

    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();

        dp = new int[n + 1][n + 1];

        for(int i = n - 1; i >= 0; i--)
        {
            for(int j = 0; j < triangle.get(i).size(); j++)
            {
                int x = triangle.get(i).get(j) + dp[i + 1][j];

                int y = triangle.get(i).get(j) + dp[i + 1][j + 1];

                dp[i][j] = Math.min(x, y);
            }
        }

        return dp[0][0];
    }
}
