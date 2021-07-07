//Time complexity is O(N)
//Space complexity is O(1)
//This solution is submitted on leetcode

public class BigN150ArithmeticSliceUsingDPInplace {
	class Solution {
		public int numberOfArithmeticSlices(int[] A) {
			// edge case
			if (A == null || A.length == 0)
				return 0;
			int sum = 0;
			int curr = 0;
			int right = 0;
			for (int i = A.length - 3; i >= 0; i--) {
				if (A[i + 1] - A[i] == A[i + 2] - A[i + 1]) {
					curr = right + 1;
					sum += curr;
					right = curr;
				} else
					right = 0;
			}
			return sum;
		}
	}
}