// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int sum = 0;
        int[] dp = new int[n];

        for(int i = n-3; i >= 0; i--){
            if(nums[i+1] - nums[i] == nums[i+2] - nums[i+1]){
                dp[i] = 1 + dp[i+1];
                sum += dp[i];
            }
        }
        return sum;
    }
}