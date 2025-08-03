class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
      int n = triangle.size();
      int[] dp = new int[n];
      //set bottom row
      for(int j = 0; j<n ; j++){
        dp[j] = triangle.get(n-1).get(j);
      }

      //start filling dp array from last but one row to top row
      for(int i = n-2 ; i >=0 ; i--){
        for(int j = 0 ; j <=i ; j++){
          dp[j] = triangle.get(i).get(j) + Math.min(dp[j] , dp[j+1]);
        }
      }
      return dp[0]; //top row's val is min
        
    }
}