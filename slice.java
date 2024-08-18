// Time Complexity : 0(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        int count = 0;
        for (int i = n - 3; i >= 0; i--) {
            if (nums[i + 1] - nums[i] == nums[i + 2] - nums[i + 1]) {
                dp[i] = 1 + dp[i + 1];
            }
            count += dp[i];
        }

        return count;
    }
}