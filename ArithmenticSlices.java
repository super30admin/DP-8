// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        
        if(A==null || A.length==0) return 0;
        if(A.length==1) return 0;
        
        int[] dp = new int[A.length];
        
       int count =0;
        
        for(int i = 2;i<A.length;i++){
            if(A[i]-A[i-1] == A[i-1]-A[i-2]){
                dp[i] = dp[i-1]+1;
                count+=dp[i];
            }        
        }
        return count;
        
    }
}