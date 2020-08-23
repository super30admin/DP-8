
// Brute Force Approach
// Time Complexity: O(n^2)

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3) return 0;
        int n = A.length;
        int count = 0;

        for(int i = 0 ; i < n - 2 ; i++){
            int diff = A[i+1] - A[i];
            for(int j = 0 ; j < n - 1; j++){
                if(A[j+1] - A[j] == diff){
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

// Dynamic Programming Approach (Bottom Up)
// Time Complexity: O(n)

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3) return 0;
        int n = A.length;
        int sum = 0;
        int [] dp = new int[n];

        for(int i = n-3 ; i >= 0; i--){
            if(A[i+1] - A[i] == A[i+2] - A[i+1]){
                dp[i] = 1 + dp[i+1];
                sum += dp[i];
            }
        }
        return sum;
    }
}


// Approach without dp array
// O(1) space

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3) return 0;
        int n = A.length;
        int sum = 0;
        int prev = 0;

        for(int i = 2 ; i < n; i++){
            if(A[i] - A[i-1] == A[i-1] - A[i-2]){
                prev = prev + 1;
                sum += prev;
            }
            else {
                prev = 0; // we don't get the correct slice, we reset prev to 0
            }
        }
        return sum;
    }
}



