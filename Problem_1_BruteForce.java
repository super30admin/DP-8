// Time complexity - O(N^2)
// Space complexity - O(1)

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length == 0) return 0;
        int n = A.length;
        int count = 0;
        for(int i = 0; i < n-2; i++){
            int d = A[i+1] - A[i];
            for(int j = i+1; j < n - 1; j++){
                if(A[j+1] - A[j] == d ){
                    count++;
                }else{
                    break;
                }
            }
        }
        return count;
    }
}
