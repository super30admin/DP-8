/*Running Time complexity: O(mxn)
Space Complexity: O(n)
Successfully Run and Compiled on leetcode
*/
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null || triangle.size()==0 || triangle.get(0).size()==0) return 0;
        int[] dp = new int[triangle.size()];
        for(int i = 0;i<dp.length;i++){
            dp[i] = triangle.get(dp.length-1).get(i);
        }
        
        for(int i = dp.length-2;i>=0;i--){
            for(int j = 0;j<=i;j++){
                dp[j] = Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
            }
        }
        
         
        return dp[0];
    }
}