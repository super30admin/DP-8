// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

// We use a dp array of size n and initialize a count variable
// As we iterate through the input array, if A[i] - A[i - 1] == A[i - 1] -A[i - 2]
// update the dp[i] to 1 + dp[i - 1] and increment count by dp[i]
// return count

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        
        if(A == null || A.length < 3) return 0;
        
        int count = 0;
        
        int[] dp = new int[A.length];
        
        for(int i = 2; i < A.length; i++) {
            if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = 1 + dp[i - 1];
                count += dp[i];
            }
        }
        return count;
    }
}