//Time complexity is O(N)
//Space complexity is O(N)
//This solution is submitted on leetcode

public class BigN150ArithmeticSliceUsingDPArray {
	class Solution {
		public int numberOfArithmeticSlices(int[] A) {
			// edge case
			if (A == null || A.length == 0)
				return 0;
			int sum = 0;
			int[] dp = new int[A.length];
			for (int i = dp.length - 3; i >= 0; i--) {
				if (A[i + 1] - A[i] == A[i + 2] - A[i + 1]) {
					dp[i] = dp[i + 1] + 1;
					sum += dp[i];
				}
			}
			return sum;
		}
	}
}