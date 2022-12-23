//TC: O(N)
//SC: O(N)
//using dp

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int result = 0;
        int[] dp = new int[nums.length];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                result += dp[i];
            }
        }
        return result;
    }
}