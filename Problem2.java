class Solution {
    //TC: O(n^2)
    //SC: O(n^2)
    int [][] dp;

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size(); 
        this.dp = new int[n][n]; 
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        return helper(triangle, 0 ,0);       
    }
    private int helper(List<List<Integer>> triangle, int i, int j){
        if(i == triangle.size()) return 0;
        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        //case1
        int min = Math.min(helper(triangle,i+1,j), helper(triangle,i+1,j+1));
        int result = triangle.get(i).get(j) + min;
        dp[i][j] = result;
        return result;

    }
}
