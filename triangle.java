// Time Complexity : O(N) 
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    1. Go bottom up and add the smallest child to the current number
    2. Kepp doing this all the way up to the root
*/


// Your code here along with comments explaining your approach
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
         if(triangle == null || triangle.size() == 0 || triangle.get(0) == null || triangle.get(0).size() == 0)
            return 0;

        int n = triangle.size();
        int minVal = triangle.get(0).get(0);
        int[] dp = new int[n];
        for(int i = 0; i < n; i++)
            dp[i] = triangle.get(n-1).get(i);

        for(int i = n-2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
