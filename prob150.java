// S30 Big N Problem #150 {Medium}
// 413. Arithmetic Slices

// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None

// Your code here along with comments explaining your approach
class Solution {
    
    //Time complexity: O(n)
    //Space complexity: O(1)
    public int numberOfArithmeticSlices(int[] A) {
        int count=0;
        int curr=0; int right=0;
        for(int i=A.length-3;i>=0;i--){
            if(A[i+1]-A[i] == A[i+2]-A[i+1]){
                curr=right+1;
                count+=curr;
                right=curr;
            }else{
                right=0;
            }
        }
        return count;
    }
    
    //Time complexity: O(n)
    //Space complexity: O(n)
    public int numberOfArithmeticSlices2(int[] A) {
        int [] dp=new int[A.length];
        int count=0;
        for(int i=dp.length-3;i>=0;i--){
            if(A[i+1]-A[i] == A[i+2]-A[i+1]){
                dp[i]=dp[i+1]+1;
                count=count+dp[i];
            }
        }
        return count;
    }
    
    //Brute force solution
    //Time complexity: O(n^2)
    public int numberOfArithmeticSlices1(int[] A) {
        if(A==null || A.length==0) return 0;
        int count=0;
        for(int i=0;i<A.length-2;i++){
            int diff=A[i+1]-A[i];
            for(int j=i+1;j<A.length-1;j++){
                if(A[j+1]-A[j]==diff){
                    count++;
                }else break;
            }
        }
        return count;
    }
}