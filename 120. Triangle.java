class Solution {// Time of O(row*col) and space of N
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int[] dp = new int[triangle.size()+1] ; 
        
        for(int row = triangle.size()-1 ; row>=0 ; row--){
            for(int col = 0; col<=row ; col++){
                dp[col] = Math.min(dp[col],dp[col+1]) + triangle.get(row).get(col);
            }
        }
        return dp[0];
    }
}