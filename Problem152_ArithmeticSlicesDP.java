//Time Complexity: O(n)
//Space Complexity: O(n)

public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        //size of array
        int n = A.length;
        //consider dp of n size
        int[] dp = new int[n];
        int result = 0;
        //i starts from 2 cz we need atleast 3 elements to check Airthmetic Progression
        //1,2,3,4 
        for (int i = 2; i < dp.length; i++) {
            //if (2-1) == (3-2) : as AP condition
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                //until i; from prev + 1
                dp[i] = dp[i - 1] + 1;
                //add with result
                result += dp[i];
            }
        }
        return result;
    }
}