class Solution {
    int slices= 0;
    public int numberOfArithmeticSlices(int[] A) {
        int  dp = 0;
        
        for(int i=A.length-3; i>=0 ; i--){
            if(A[i+1]-A[i] == A[i+2]- A[i+1]){
                dp = 1+dp;
                slices+= dp;
            }else{
                dp=0;
            }
            
        }  
    return slices;
    }
