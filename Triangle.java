// Time Complexity : O(N) 
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0) return 0;
        int[] dp = new int[triangle.get(triangle.size() - 1).size()];
        for(int i = 0; i < dp.length; i++) {
            dp[i] = triangle.get(triangle.size() - 1).get(i);
        }
        
        
        
        for(int row = triangle.size() - 2; row >= 0; row--) {
            for(int i = 0; i <= row; i++) {
                dp[i] = Math.min(dp[i], dp[i + 1]) + triangle.get(row).get(i);
            }
        }
        
        return dp[0];
    }
}