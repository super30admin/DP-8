// Time Complexity :O(n) where n is no of elements in triangle
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();

        int[][] dp = new int[m][m];
        // populate last row first
        for (int i = 0; i < m; i++) {
            dp[m - 1][i] = triangle.get(m - 1).get(i);
        }
        // at every index, take min of next row's i and i+1 and add current
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {

                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j],
                        dp[i + 1][j + 1]);

            }
        }
        // we'll find our result at the top
        return dp[0][0];
    }
}

// ----------------USING ONE DIMENSIONAL ARRAY--------------------------------
// Time Complexity :O(MN) where M is no of ROWS and N is no of columns in
// triangle
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();

        int[] dp = new int[m];
        for (int i = 0; i < m; i++) {
            dp[i] = triangle.get(m - 1).get(i);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                // System.out.println("i and j are"+i+" and "+j);
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j],
                        dp[j + 1]);
                // System.out.println("dp i and j is"+dp[i][j]);
            }
        }
        return dp[0];
    }
}

// -----------WITH PATH------------------------------
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