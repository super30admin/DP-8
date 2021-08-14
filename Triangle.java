// Time Complexity :O(n*n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
* 1 .bottom DP
/*

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[] dp=new int[n];
        
        //copy last row to dp array
        for(int i=0;i<n;i++){
            dp[i]=triangle.get(n-1).get(i);
        }
        
        //bottom up loop
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[j]=triangle.get(i).get(j)+Math.min(dp[j],dp[j+1]);   
            }
        }
        
        return dp[0];
    }
}