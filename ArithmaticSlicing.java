package dp8;

// TC : O(n)
public class ArithmaticSlicing {

	class Solution {
	    
        int slices = 0;
    
    public int numberOfArithmeticSlices(int[] A) {
    
        makeSlices(A, A.length - 1);
        
        return slices;
    }
    
      private int makeSlices(int[] A, int i) {
          
          if(i < 2) return 0;
          
          int sum = 0;
          
          if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
              
              sum = makeSlices(A, i - 1) + 1;
              
              slices += sum;
          }
          else {
              makeSlices(A, i - 1);
          }
          
          return sum;
      }  
        
        
        // with just a variable
  /*      
         if(A.length < 2) return 0;
        
         int prev = 0;
         int sum = 0;
        
         for(int i = 2; i < A.length; i++) {
             if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                 prev = prev + 1;
                 sum += prev;
             }
             else {
                 prev = 0;
             }
         }
        
         return sum;
   */     
        // with dp array
    /*    
         if(A.length < 2) return 0;
        
         int[] dp = new int[A.length];
        
         int sum = 0;
        
         for(int i = 2; i < A.length; i++) {
             if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                 dp[i] = dp[i - 1] + 1;
                
                 sum += dp[i];
             }
         }
         return sum;
    */
}
	
}
