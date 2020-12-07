// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
//dp[i] indicates #slices with slices ending with A[i], if A[i]-A[i-1]==A[i-1]-A[i-2] then dp[i] = dp[i-1]+1
// return overall sum of all slices

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int[] dp = new int[A.length];
        
        int sum = 0;
        for(int i=2; i<A.length; i++){
            if(A[i]-A[i-1]==A[i-1]-A[i-2]){
                //slices that end with ith index element
                dp[i] = 1+dp[i-1];
                sum += dp[i];
            }
        }
        
        return sum;
    }
}