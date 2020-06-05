class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        return dp2(triangle);
    }

    // Method 1 DP (Non-Recursive) Space O(n) Time O(m*n)
    private int dp1(List<List<Integer>> triangle){
        int rows = triangle.size();
        int[] dp = new int[rows+1];
        for(int i = rows-1; i>=0; i--){

            for(int j = 0; j <=i; j++){
                dp[j] = Math.min(dp[j],dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    // Method 2 DP (Recursive)  Space O(m*n) Time O(m*n)
    private int dp2(List<List<Integer>> triangle){
        if(triangle == null || triangle.size() ==0)
            return 0;
        Integer[][] dp = new Integer[triangle.size()][];
        return helper(triangle,0,0,dp);
    }

    private int helper(List<List<Integer>> triangle, int row, int col, Integer[][] dp){

        if(row == triangle.size())
            return 0;

        if(dp[row]==null){
            dp[row] = new Integer[triangle.get(row).size()];
        }

        if(dp[row][col] != null){
            return dp[row][col];
        }

        int left = helper(triangle,row+1,col,dp);
        int right = helper(triangle,row+1,col+1,dp);
        dp[row][col] = Math.min(left,right) + triangle.get(row).get(col);
        return dp[row][col];
    }

}