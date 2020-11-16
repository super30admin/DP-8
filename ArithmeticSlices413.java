class Solution {
    // Approach: Dynamic Prog
    // ==> Adding number of Slices at each index = value at prev index + 1
        
    // Time Complexity:    O(n)
    // Space Complexity:   O(1)
        
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3)
            return 0;
        
        int prev_diff = A[1] - A[0], res = 0, count = 0;
        
        int curr_diff;
        for(int i = 2; i < A.length; i++){
            
            curr_diff = A[i] - A[i-1];
            
            if(A[i-1] - A[i-2] == A[i] - A[i-1]){
                count = count + 1;
                res += count;
            } else {
                count = 0;
            }
        }
        return res;
    }
}