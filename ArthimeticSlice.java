//bruteforce
//time o(n pow 2)
//space o(1)
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3)
            return 0;
        int count = 0;
        
        for(int i=0; i<A.length-2; i++) {
            int diff = A[i+1] - A[i];
            for (int j=i+2; j<A.length; j++) {
                if(A[j] - A[j-1] == diff) {
                    count++;
                }
                else {
                    break;
                }
            }
        }
        return count;
    }
}

//DP
//time o(n)
//space o(n)
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3)
            return 0;
        int sum =0;
        
        int[] dp = new int[A.length];
        for(int i=A.length-3; i>=0; i--) {
            if(A[i+1]-A[i] == A[i+2]-A[i+1]) {
                dp[i] = dp[i+1] + 1;
                sum += dp[i];
            }
        }
        return sum;
    }
}

//Optimization
//time o(n)
//space o(1)
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3)
            return 0;
        int sum =0;
        
        int right = 0;
        for(int i=A.length-3; i>=0; i--) {
            if(A[i+1]-A[i] == A[i+2]-A[i+1]) {
                sum += right + 1;
                right = right + 1;
            }
            else {
                right = 0;
            }
        }
        return sum;
    }
}