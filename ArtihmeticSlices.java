// using constant space
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 2) return 0;
        int prev = 0;
        int sum = 0;
        for(int i=2;i<A.length;i++) {
            if(A[i] - A[i-1] == A[i-1] - A[i-2]) {
                prev++;
                sum += prev;
            }
            else prev = 0;
        }
        return sum;
    }
}

// using constant space dp
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 2) return 0;
        int sum = 0;
        int[] dp = new int[A.length];
        for(int i=2;i<A.length;i++) {
            if(A[i] - A[i-1] == A[i-1] - A[i-2]) {
                dp[i] = 1 + dp[i-1];
                sum = sum+dp[i];
            }
        }
        return sum;
    }
}

// using recursion
class Solution {
    int totalSlices = 0;
    public int numberOfArithmeticSlices(int[] A) {
         helper(A, A.length-1);
        return totalSlices;
    }
    
    public int helper(int[] A, int i) {
        if(i<2) return 0;
        int currSum = 0;
        if(A[i] - A[i-1] == A[i-1] - A[i-2]) {
            currSum = 1 + helper(A, i-1);
            totalSlices+=currSum;
        }
        else helper(A, i-1);
        return currSum;
    } 
}