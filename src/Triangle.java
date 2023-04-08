import java.util.List;
//Time Complexity : O(N * M) when N is the number of rows, M is the max number of elements in the last row.
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * At each step except last one, take the minimum of next step's current and
 * current + 1 elements and add it to the current element. Update the current
 * element with that sum. Itearate till it reaches the 0th row. Return 0th row.
 *
 */
class Solution {
	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				int sum = triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
				triangle.get(i).set(j, sum);
			}
		}
		return triangle.get(0).get(0);
	}
}
