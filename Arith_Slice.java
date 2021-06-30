

// Time : O(N) 

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
        
        
      
	
}
