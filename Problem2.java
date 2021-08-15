// time - O(n^2)
// space - O(n)


class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        if(triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) return 0;
        int n = triangle.size();

        int [] dp = new int[n];

        for(int i = 0; i < dp.length; i++) { // store the last row in the dp array
            dp[i] = triangle.get(n-1).get(i);
        }

        for(int i = n - 2; i >= 0; i--) {
            for(int j = 0; j <= i; j++){
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j],dp[j+1]); // add the current element at that index position with min between j & j+1
            }
        }
        return dp[0];
    }
}