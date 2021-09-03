// Time Complexity : O(m * n)
// Space Complexity : O(1)

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0)
            return 0;
        int n = triangle.size();
        int[] dp = new int[n];
        for(int j = 0; j < n; j++){
            dp[j] = triangle.get(n - 1).get(j);
        }
        for(int i = n - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }
}