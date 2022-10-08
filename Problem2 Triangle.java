//Space complexity: O(N) for 1D DP array
//Time complexity: O(N*N) 

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //Without mutating list of integer triangle and using 1D dp array
        int n = triangle.size();
     //   if (n == 1) return triangle.get(0).get(0);
        int [] dp = new int[n];
        for(int k=0;k<n;k++){ //populate dp with elements from last row of triangle list
            dp[k] = triangle.get(n-1).get(k);
        }
//start i as n-2nd index row and start j as 0th element of that row
//bottom up dp
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){ //or j<triangle.get(i).size()
            dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
            }
        }
        return dp[0];
    }
}
