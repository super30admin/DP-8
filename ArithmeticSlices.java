// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    We use a DP array to keep track of the number of possible slices.
*/

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
        int sum = 0;
        
        int [] dp = new int[nums.length];
        
        for (int i=2; i<nums.length; i++){
            
            if (nums[i]-nums[i-1] == nums[i-1]-nums[i-2])
                dp[i] = dp[i-1]+1;
            
            sum += dp[i]; 
        }
        
        return sum;
    }
}