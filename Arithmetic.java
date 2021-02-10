// A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
// TC O(N) SC O(1)
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        
        int count = 0;
        int prev = 0, curr = 0;
       for (int i = 2; i < A.length; i++){
           if (A[i-1]-A[i-2] == A[i]-A[i-1]){
               curr = prev +1;
               count = count + curr;
               prev = curr;
           }
           else {
               prev = 0;
           }
       }
        return count;
    }
}
