import java.util.List;
// Time Complexity : O(2^(m+n)) m is the number of rows in triangle and n is the number of elements in a row
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
public class TriangleUsingRecursion {
    int[][] dp;
    int m ;
    public int minimumTotal(List<List<Integer>> triangle) {
        m = triangle.size();
        dp = new int[m][m];
        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        return helper(triangle,0,0);
    }

    private int helper(List<List<Integer>> triangle, int r, int c){

        int case0 = 0;
        if(r+1 < m)
        {
            if(dp[r+1][c] == Integer.MAX_VALUE)
                dp[r+1][c] = helper(triangle, r+1, c);
            case0 = dp[r+1][c];
        }
        int case1 =0;

        if(r+1 < m)
        {
            if(dp[r+1][c+1] == Integer.MAX_VALUE)
                dp[r+1][c+1] = helper(triangle, r+1, c+1);
            case1 = dp[r+1][c+1];
        }

        return Math.min(case0, case1)+triangle.get(r).get(c);
    }
}

