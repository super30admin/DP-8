// Time complexity - O(N)
// Space complexity - O(N)

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length == 0) return 0;
        int sum = 0;
        int n = A.length;
        int[] dp = new int[n];
        for(int i = n - 3; i >= 0; i--){
            if(A[i+1] - A[i] == A[i+2] - A[i+1] ){
                dp[i] = dp[i+1] + 1;
                sum += dp[i];
            }
        }
        return sum;
    }
}
