TC:O(triangle.size())
SC:O(n) - for dp array
Succefully run on leetcode
used a 1D DP array to store the min sum so far 

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //take a dp array and store the min path sums
        int n=triangle.size();
        int []dp = new int[n];
        for(int j=0;j<n;j++){//initiall store the last row elements in the dp array and update later
            dp[j] = triangle.get(n-1).get(j);
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                int a = triangle.get(i).get(j);
                int b = Math.min(dp[j],dp[j+1]);
                dp[j]=a+b;
            }
            
        }
        return dp[0];
    }
}