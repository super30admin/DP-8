// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :nopes
class SolutionOne {
    public int numberOfArithmeticSlices(int[] A)
    {

        if(A==null||A.length<3)
            return 0;

        int sum = 0;
        int curr = 0;
        int prev = 0;
        // int[] dp = new int[A.length];

        for(int i=2;i<A.length;i++)
        {
            if( A[i]-A[i-1] == A[i-1]-A[i-2] )
            {
                curr = prev+1;
                sum = sum + curr;
                prev = curr;
                // dp[i]= dp[i-1]+1;
                // sum = sum + dp[i];
            }
            else
            {
                prev = 0;
            }
        }

        return sum;
    }
}