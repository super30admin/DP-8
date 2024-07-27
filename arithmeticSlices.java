class Solution {
    // Tc: O(n) Sc: O(n)
    public int numberOfArithmeticSlices(int[] nums) {
        int dp[] = new int[nums.length];
        int cnt = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                cnt += dp[i];
            }
        }
        return cnt;
    }
}

/*
 * class Solution {
 * public int numberOfArithmeticSlices(int[] nums) {
 * // Tc: O(n^2) Sc: O(1)
 * if (nums == null || nums.length == 0)
 * return 0;
 * int cnt = 0;
 * for (int i = 0; i < nums.length - 2; i++) {
 * int diff = nums[i + 1] - nums[i];
 * for (int j = i + 1; j < nums.length - 1; j++) {
 * if (diff == nums[j + 1] - nums[j]) {
 * cnt += 1;
 * } else {
 * break;
 * }
 * }
 * }
 * 
 * return cnt;
 * 
 * }
 * }
 * 
 */