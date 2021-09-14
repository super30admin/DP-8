// Time Complexity : O(m*n), m -> Number of elements, n -> Number of rows
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Triangle {
	/********************* Bottom-up DP - Array *********************/
	// Time Complexity : O(m*n), m -> Number of elements, n -> Number of rows
	// Space Complexity : O(n)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public int minimumTotalBottomUpArray(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}

		int n = triangle.size();
		int[] dp = new int[n];

		for (int i = 0; i < n; i++) {
			dp[i] = triangle.get(n - 1).get(i);
		}

		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
			}
		}

		return dp[0];
	}

	/********************* Bottom-up DP - In-Place *********************/
	// Time Complexity : O(m*n), m -> Number of elements, n -> Number of rows
	// Space Complexity : O(1)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}

		int n = triangle.size();

		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				triangle.get(i).set(j,
						triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
			}
		}

		return triangle.get(0).get(0);
	}

	/********************* Top-Down DP - In-Place *********************/
	// Time Complexity : O(m*n), m -> Number of elements, n -> Number of rows
	// Space Complexity : O(1)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public int minimumTotalTopDown(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}

		int n = triangle.size();

		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i - 1).get(j));
				} else if (j == i) {
					triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i - 1).get(j - 1));
				} else {
					triangle.get(i).set(j, triangle.get(i).get(j)
							+ Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j)));
				}
			}
		}

		return Collections.min(triangle.get(n - 1));
	}

	public static void main(String[] args) {
		Triangle obj = new Triangle();
		List<List<Integer>> triangle = new ArrayList<>();
		triangle.add(new ArrayList<>(Arrays.asList(2)));
		triangle.add(new ArrayList<>(Arrays.asList(3, 4)));
		triangle.add(new ArrayList<>(Arrays.asList(6, 5, 7)));
		triangle.add(new ArrayList<>(Arrays.asList(4, 1, 8, 3)));

		System.out.println("Minimum path sum: " + obj.minimumTotal(triangle));
	}

}
