// Time complexity is O(N^2)
// Space complexity is O(1)
// This solution is submitted on leetcode

public class BigN150ArithmeticSlicesBruteForceSolution {
	class Solution {
		public int numberOfArithmeticSlices(int[] A) {
			// edge case
			if (A == null || A.length == 0)
				return 0;
			int count = 0;
			for (int i = 0; i < A.length - 2; i++) {
				int diff = A[i + 1] - A[i];
				for (int j = i + 1; j < A.length - 1; j++) {
					if (A[j + 1] - A[j] == diff)
						count++;
					else
						break;
				}
			}
			return count;
		}
	}
}