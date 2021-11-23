// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class triangles {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
		for(int i=0;i<triangle.size() ;i++)
        {
            dp[triangle.size()-1][i]=triangle.get(triangle.size()-1).get(i);   
        }
        
        for(int i=triangle.size()-2;i>=0;i--){
            for(int j = 0; j <= i; j++)
            {
        dp[i][j]= triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }
       return dp[0][0]; 
    }
}
