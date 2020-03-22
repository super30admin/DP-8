// Time Complexity : O(n) where n is the length of the array A
// Space Complexity : O(n) where n is the length of the array A
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// DP: iterate from end - 2 to 0: 
    // if valid slice, dp[i] = dp[i-1] + 1 (one more than prev num of slices as we add a new number)
// output sum of all values in dp array

class arithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length == 0) return 0;
        int[] dp = new int[A.length];
        int ans = 0;
        for (int i = A.length - 3; i >= 0; i--) {
            if (A[i + 1] - A[i] == A[i + 2] - A[i + 1]) {
                dp[i] = dp[i + 1] + 1;
                ans += dp[i];
            }
        }
        return ans;
    }
}