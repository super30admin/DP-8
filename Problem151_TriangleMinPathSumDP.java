//Time Complexity:O(n)

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // base case
        if(triangle == null || triangle.size() == 0) 
            return 0;
        
        int m = triangle.size();
        //last row size
        int row = triangle.get(m - 1).size();
        //consider dp for each row from bottom
        int[] dp = new int[row];
        for(int i = 0; i < row; i++){
            dp[i] = triangle.get(m - 1).get(i);
        }
        
        //bottom up
        for(int i = row - 2; i >= 0; i--){
            List<Integer> curVal = triangle.get(i);
            for(int j = 0; j < curVal.size(); j++){
                //consider the min of the adjacent numbers + curr val of prev row
                // dp[j] = min of(2 adjacent values) + curVal
                dp[j] = Math.min(dp[j], dp[j + 1]) + curVal.get(j);
            }
        }
        
        return dp[0]; 
    }
}