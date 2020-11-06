class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0)
            return 0;
        
        int dp[] = new int[triangle.get(triangle.size()-1).size()];
        
        for(int i=0;i<dp.length;i++){
            dp[i] = triangle.get(triangle.size()-1).get(i);
        }
        
        for(int i = dp.length - 2; i>=0 ; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        
        return dp[0];
    }
}