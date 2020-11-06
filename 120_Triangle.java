    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/triangle/
    Time Complexity for operators : O(1/2 * (n-1) * n) … n = is the size of List
    Extra Space Complexity for operators : O(n) .. n = is the size of List
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) Create an dp array of size n, n is the size of triangle.
                    B) Fill all the values of the last row from the triangle.
                    C) Now two for loops for the iteration, and get the
                        dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
                    D) At the end, our answer will be at first index of array return it.
    */ 

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