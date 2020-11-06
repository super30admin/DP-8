class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length == 0)
            return 0;
        
        int prev = 0;
        int sum = 0;
        
        for(int i = A.length - 3; i >= 0; i--){
            if(A[i]-A[i+1] == A[i+1]-A[i+2]){
                prev = 1 + prev;
                sum += prev;
            }else
                prev = 0;
        }
        
        return sum;
    }
}