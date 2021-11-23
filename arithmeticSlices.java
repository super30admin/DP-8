// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class arithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        
        int[] dp = new int[nums.length];
        int sum = 0;

        for(int i = 2; i< nums.length; i++) {
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                dp[i] = 1 + dp[i-1];
                sum += dp[i];
            }
        }
        return sum;
    }
}
