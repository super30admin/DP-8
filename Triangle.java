// Time Complexity :O(m*n)triangle.size() * triangle.get(triangle.size()-1).size()
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
     if(triangle == null || triangle.get(0) == null || triangle.size() == 0 || triangle.get(0).size() == 0)
         return 0;
        
    int[] dp = new int[triangle.size()];
    
    for(int j = 0; j< triangle.size(); j++)
        dp[j] = triangle.get(triangle.size() - 1).get(j);
   
    for(int i = triangle.size() - 2; i >= 0; i--){
        for(int j = 0; j <= i; j++  )
            dp[j]= Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);   
    }
    return dp[0];
    }
}

