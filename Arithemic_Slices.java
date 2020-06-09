// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int[] dp = new int[A.length];
        for(int i=A.length-3; i>=0; i--)
        {
            if(A[i+1]-A[i] == A[i+2]-A[i+1])
                dp[i]=dp[i+1]+1;
        }
        int count=0;
        for(int i=0; i < dp.length; i++)
        {
            count+=dp[i];
        }
        return count;
    }
}