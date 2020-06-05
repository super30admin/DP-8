// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class ArithmeticSlices {

    // Brute force
    // Time Complexity : O(n^2)
    // Space Complexity : O(1)
    public int numberOfArithmeticSlicesBF(int[] A) {
        if(A == null || A.length < 3){
            return 0;
        }
        int count = 0;
        for(int i = 0; i < A.length - 2; i++){
            int diff = A[i+1] - A[i];
            for(int j = i+1; j < A.length -1; j++){
                if(A[j+1] - A[j] == diff){
                    count++;
                } else {
                    break;
                }
            }
        }

        return count;
    }

    // Time Complexity : O(n)
    // Space Complexity : O(n)

    public int numberOfArithmeticSlicesDP1(int[] A) {
        int sum = 0;
        int[] dp = new int[A.length];

        for(int i = A.length - 3; i >=0 ; i--){
            if(A[i+2] - A[i+1] == A[i+1] - A[i]){
                dp[i] = dp[i+1] + 1;
                sum += dp[i];
            }
        }

        return sum;
    }

    // Time Complexity : O(n)
    // Space Complexity : O(1)

    public int numberOfArithmeticSlicesDP2(int[] A) {
        int sum = 0;
        int right = 0;

        for(int i = A.length - 3; i >=0 ; i--){
            if(A[i+2] - A[i+1] == A[i+1] - A[i]){
                right = right + 1;
                sum += right;
            } else {
                right = 0;
            }
        }

        return sum;
    }
}
