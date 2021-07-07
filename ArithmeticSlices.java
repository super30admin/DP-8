


class Solution {
    int slices= 0;
    public int numberOfArithmeticSlices(int[] A) {
        dfs(A,0);
        return slices;
    }
    private int dfs(int[] A, int i){
        // base case
        if(i>= A.length-2){
            return 0;
        }
        // recursive case
        int temp = 0;
        if(A[i+1]-A[i] == A[i+2]- A[i+1]){
            temp= 1+ dfs(A,i+1);
            slices+= temp;
        }
        else{
            dfs(A,i+1)    ;
        }
        return temp;
    }
}
