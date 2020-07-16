public class ArithmeticSlices {
    
    /**
     * Time complexity: O(N) where N is length of A
     * Space complexity: O(1)
     * 
     * Approach:
     * 1. Since we have to consider the consecutive numbers, we can store the count of previous APs and
     * keep adding to it if difference is same between consecutive pairs.
     */

    public int numberOfArithmeticSlices(int[] A) {
        
        if(A == null || A.length == 0)
            return 0;
        
        // int[] dp = new int[A.length];
        int count = 0;
        int sum = 0;
        for(int i=2; i<A.length; i++) {
            if(A[i] - A[i-1] == A[i-1] - A[i-2]) {
                // dp[i] = dp[i-1] + 1;
                count = count + 1;
                sum += count;
            }
            else {
                count = 0;
            }
        }
        
        return sum;
        
    }

    /**
     * Time complexity: O(N^2) where N is length of A
     * Space complexity: O(1) 

     public int numberOfArithmeticSlices(int[] A) {
        
        if(A == null || A.length == 0)
            return 0;
        int count = 0;
        
        for(int i = 0; i < A.length-2; i++){
            int diff = A[i+1] - A[i];
            for(int j = i + 2; j < A.length; j++) {
                if(A[j] - A[j-1] == diff){
                    count++;
                }else {
                    break;
                }
            }
        }
        
        return count;
    }
     */
    

}