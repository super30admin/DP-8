// Bottom Up Approach
// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[] dp = new int[n];
        int sum  = 0;
        for(int i = n - 3; i >= 0; i--) {
            if(nums[i + 2] - nums[i + 1] == nums[i + 1] - nums[i]) {
                dp[i] = dp[i + 1] + 1;
                sum += dp[i];
            }
        }
        return sum;
    }
}