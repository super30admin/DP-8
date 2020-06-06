//Time Complexity: O(n^2)
//Space Complexity: O(n)

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		int size = triangle.size();
		int[] dp = new int[size];

		for (int j = 0; j < size; j++) {
			dp[j] = triangle.get(size - 1).get(j);
		}

		for (int i = size - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
			}
		}
		return dp[0];
	}
}
