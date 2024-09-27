// Time Complexity :o(n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int numberOfArithmeticSlices(int[] A){
   int sum=0;
        int[] output=new int[A.length];
        int n=A.length;
        for(int i=n-3;i>=0;i--){
            if(A[i+2]-A[i+1] == A[i+1]-A[i]){
            output[i]=1+output[i+1];
                sum=sum+output[i];
            }
        }
        return sum;
    }
}