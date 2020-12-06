// Time Complexity : O(#elements in triangle)
// Space Complexity : O(#elements in last row in triangle)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
//build from bottom up, dp[i] = min(dp[i], dp[i+1]) + triangle[row][i]
//final min sum would be in dp[0]

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==0)
            return 0;
        if(triangle.size()==1)
            return triangle.get(0).get(0);
        
        int[] dp = new int[triangle.size()];
        
        for(int i=0; i<triangle.size(); i++){
            dp[i] = triangle.get(triangle.size()-1).get(i);
        }
        
        for(int row = triangle.size()-2; row>=0; row--){
            for(int col = 0; col<=row; col++){
                dp[col] = Math.min(dp[col], dp[col+1]) + triangle.get(row).get(col);
            }
        }
        
        return dp[0];
    }
}