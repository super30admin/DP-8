// TC: O(n)
// SC: O(1)

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null)
            return 0;
        int prev = 0, sum = 0;
        for(int i=A.length-3; i>=0; i--){
            // comparing the differences and adding to the sum and keeping track of the prev sum also
            if(A[i] - A[i+1] == A[i+1] - A[i+2]){
               prev = 1 + prev;
               sum += prev;
            }
            else{
                prev = 0;
            }
        }        
        return sum;
    }
}
