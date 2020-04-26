Time Complexity = O(n*n)
Space Complexity = O(1)

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A== null || A.length == 0)return 0;
        
        int cnt = 0;
        
        for(int i = 0; i < A.length -2; i++){
            int diff = A[i+1] - A[i];
            for(int j = i+2;  j < A.length; j++){
                if(A[j] - A[j-1] == diff)cnt++;
                else break;
            }
        }
        return cnt;
    }
}