//TC - O(N)
//SC - O(N)
class Solution1 {
	public int numberOfArithmeticSlices(int[] A) {
		if (A == null || A.length < 3)
			return 0;
		int n = A.length;
		int sum = 0;
		int[] dp = new int[n];
		for (int i = n - 3; i >= 0; i--) {
			if (A[i + 1] - A[i] == A[i + 2] - A[i + 1]) {
				dp[i] = dp[i + 1] + 1;
				sum += dp[i];
			}
		}
		return sum;
	}
}