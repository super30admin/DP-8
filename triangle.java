// Time Complexity :O(n) where n is no of elements in triangle
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes


class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] path = new int[m][m];
        int[] dp = new int[m];
        for (int i = 0; i < m; i++) {
            dp[i] = triangle.get(m - 1).get(i);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                // System.out.println("i and j are"+i+" and "+j);
                if (dp[j] > dp[j + 1]) {
                    path[i][j] = j + 1;
                } else {
                    path[i][j] = j;
                }
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j],
                        dp[j + 1]);
                // System.out.println("dp i and j is"+dp[i][j]);
            }
        }
        System.out.println("path is" + Arrays.deepToString(path));
        return dp[0];
    }
}