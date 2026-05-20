/**

 * Uses dynamic programming where dp[i] stores the number of arithmetic subarrays ending at index i.

 * If current 3 consecutive elements form an arithmetic sequence, extend previous sequences using dp[i] = dp[i-1] + 1.

 * Time Complexity: O(n), Space Complexity: O(n)

 */

public class ArithmaticSlices {
        public int numberOfArithmeticSlices(int[] A) {
        int[] dp = new int[A.length];
        int sum = 0;
        for (int i = 2; i < dp.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = 1 + dp[i - 1];
                sum += dp[i];
            }
        }
        return sum;
    }
}
