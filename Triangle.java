// Time Complexity : O(n^2) where n is the number of rows in the triangle
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create a dp matrix
// Fill in the first all with max value and first row with the one in list
// Now for each cell in dp the sub-problem would be solved by taking
// min of top and top left cells, we will calculate values for all 
// finally we wil get our answers at the last row taking min of the values.
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int[][] dp = new int[m][n+1];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j <= n; j++){
            dp[i][j] = Integer.MAX_VALUE;
        }
        }
        dp[0][1] = triangle.get(0).get(0);
        List<Integer> tri = new ArrayList<>();
        for(int i = 1; i < m; i++){
            tri = triangle.get(i);
            for(int j = 1; j <= i+1; j++){
                dp[i][j] = tri.get(j-1) + Math.min(dp[i-1][j], dp[i-1][j-1]);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= n; i++){
            if(dp[m-1][i] < min)
                min = dp[m-1][i];
        }
        return min;
    }
}