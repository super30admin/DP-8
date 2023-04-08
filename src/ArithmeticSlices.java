//Time Complexity : O(N)
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Since the actual count starts from 3rd element, maintain a dp array and
 * iterate from 3rd element to see if the arithmetic condition is satisfied. If
 * so, add previous dp element + 1. And also add all the dp values to get the
 * total count of arithmetic slices. return sum.
 *
 */
class Solution {
	public int numberOfArithmeticSlices(int[] nums) {
		int sum = 0;
		int[] dp = new int[nums.length];
		for (int i = 2; i < dp.length; i++) {
			if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
				dp[i] = dp[i - 1] + 1;
				sum += dp[i];
			}
		}
		return sum;
	}
}