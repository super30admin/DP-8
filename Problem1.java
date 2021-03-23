//Recursve Solution TC-- O(n),  SC-- Recursive stack.

class Solution {
    int slices = 0;
    public int numberOfArithmeticSlices(int[] A) {
     helper(A,A.length -1);
      return slices;  
        
    }
    private int helper(int[] A,int i){
        // base case
        if(i<2) return 0;
        int temp =0; 
        if(A[i] - A[i-1] == A[i-1] - A[i-2]){
            temp = 1 + helper(A,i-1);
            slices += temp;
        }
        else{
            helper(A,i-1);
        }
    return temp;     
  }
    
}


//DP Solution TC-- O(n),  SC-- O(n)
class Solution {
    
    public int numberOfArithmeticSlices(int[] A) {
     if(A.length<2) return 0;
     int dp[] = new int[A.length];
     int slices =0;   
     for(int i=2;i<A.length; i++){
         if(A[i] - A[i-1] == A[i-1] - A[i-2] ){
             dp[i] = dp[i-1]+1;
             slices += dp[i];
         }
     }   
     return slices;   
    }
 }
 
 //Constant Solution TC-- O(n),  SC-- O(1)
class Solution {
    
    public int numberOfArithmeticSlices(int[] A) {
     if(A.length<2) return 0;
    int prev=0;
     int slices =0;   
     for(int i=2;i<A.length; i++){
         if(A[i] - A[i-1] == A[i-1] - A[i-2] ){
            prev = prev+1;
             slices += prev;
         }else{
             prev =0;  // missed in first attempt
         }
     }   
     return slices;   
    }
 }
 
 
