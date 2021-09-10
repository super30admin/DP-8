// Time Complexity : O(n), n -> Number of elements in the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

public class ArithmeticSlices {
	/********************* DP - Bottom-up *********************/
	// Time Complexity : O(n), n -> Number of elements in the array
	// Space Complexity : O(n)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public int numberOfArithmeticSlicesBottomUp(int[] nums) {
		if (nums == null || nums.length < 3) {
			return 0;
		}

		int n = nums.length;
		int[] dp = new int[n];
		int sum = 0;

		for (int i = n - 3; i >= 0; i--) {
			if (nums[i] - nums[i + 1] == nums[i + 1] - nums[i + 2]) {
				dp[i] = dp[i + 1] + 1;
			}
			sum += dp[i];
		}

		return sum;
	}

	/********************* DP - Top-Down *********************/
	// Time Complexity : O(n), n -> Number of elements in the array
	// Space Complexity : O(n)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public int numberOfArithmeticSlicesTopDown(int[] nums) {
		if (nums == null || nums.length < 3) {
			return 0;
		}

		int n = nums.length;
		int[] dp = new int[n];
		int sum = 0;

		for (int i = 2; i < n; i++) {
			if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
				dp[i] = dp[i - 1] + 1;
			}
			sum += dp[i];
		}

		return sum;
	}

	/********************* DP - Top-Down Optimized Space *********************/
	// Time Complexity : O(n), n -> Number of elements in the array
	// Space Complexity : O(1)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public int numberOfArithmeticSlices(int[] nums) {
		if (nums == null || nums.length < 3) {
			return 0;
		}

		int n = nums.length;
		int curr = 0;
		int prev = 0;
		int sum = 0;

		for (int i = 2; i < n; i++) {
			if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
				curr = prev + 1;
				prev = curr;
				sum += curr;
			} else {
				prev = 0;
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		ArithmeticSlices obj = new ArithmeticSlices();
		int[] nums = { 1, 2, 3, 4, 5 };

		System.out.println("Number of arithmetic slices in the given array: " + obj.numberOfArithmeticSlices(nums));
	}

}
