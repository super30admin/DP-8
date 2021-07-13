//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this : no
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
        if(nums.length < 3){
            
            return 0;
        }
        
        int[] dp = new int[nums.length];
        int count = 0;
        
        for(int i = 2; i < nums.length; i ++){
            
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                
                dp[i] = dp[i-1] + 1;
                count += dp[i];
            }
        }
        
      
        return count;
    }
}