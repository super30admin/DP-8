class Solution {
    public int numberOfArithmeticSlices(int[] A) {

        if(A==null || A.length <=2)
            return 0;

        // return bruteForce(A);
        return dp2(A);
    }

    //brute force  space O(1) time O(n^2)
    private int bruteForce(int[] A){

        int count = 0;
        for(int i=0; i<A.length-2; i++){
            for(int j= i+1; j < A.length-1; j++){
                if(A[j]-A[j-1] == A[j+1]-A[j]){
                    count++;
                }else{
                    break;
                }
            }
        }
        return count;
    }

    // DP solution space O(n) time O(n)
    private int dp1(int[] A){

        int[] dp = new int[A.length];
        int count = 0;
        for(int i=A.length-2;i>=1; i--){
            if(A[i] - A[i-1] == A[i+1]-A[i]){
                dp[i-1] = dp[i] + 1;
                count += dp[i-1];
            }
        }
        return count;
    }

    // DP solution space O(1) time O(n)
    private int dp2(int[] A){

        int count = 0;
        int right = 0;
        for(int i=A.length-2;i>=1; i--){
            if(A[i] - A[i-1] == A[i+1]-A[i]){
                right = right + 1;
                count += right;
            }else{
                right = 0;
            }
        }
        return count;
    }


}