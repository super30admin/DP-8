//Time complexity:O(n)
//Space complexity:O(1)
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A==null || A.length==0){
            return 0;
        }
        int result=0;
        int sum=0;
        for(int i=0;i<A.length-2;i++){
            if(A[i]-A[i+1]==A[i+1]-A[i+2]){
                result+=1;
                sum+=result;
            }else{
                result=0;
            }
        }
        return sum;
    }
}