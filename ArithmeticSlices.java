/*
 * Time complexity : O(n)
 * Space Complexity : O(n)
 */
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        
        if(A == null || A.length == 0){
            return 0;
        }
        
        int[] result = new int[A.length];
        int count = 0;
        
        for(int i=A.length - 3; i >=0 ; i--){
            if(A[i+1] - A[i] == A[i+2] - A[i+1]){
                result[i] = result[i+1]+1;
                count += result[i];
            }
        }
        
        return count;
    }
}