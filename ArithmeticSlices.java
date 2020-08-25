//Time Complexity: O(n) 
//Space Complexity: O(n) 

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length == 0 || A == null)
            return 0;
        
        int[] dp = new int[A.length];
        
        int count = 0;
        
        for(int i=dp.length-3;i>=0;i--){
            if(A[i+1] - A[i] == A[i+2] - A[i+1] ){
                dp[i] = 1 + dp[i+1];
                count = count + dp[i];
            }
        }
        
        return count;
    }
}