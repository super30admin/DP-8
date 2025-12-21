// Time Complexity :O(n^2)
// Space Complexity :O(n^2)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
Approach
we are using Dp tabulation methord to solve the nested itterations
we take dp of size of nums
then we take a for till n-3, because in the loop we are check value of i+2, so in loop till n-1 we
will do out of bounds
in loop we check difference between i,i+1,i+2 is equal or not, if yes we 1 + prev dp value at 
the current dp value

there might be a case where slice is starting from 0 which will cause prev dp check to fail
so at i=0 if there is a slice we directly make dp[0] = 1

after increasing the dp value we add it to result and in the end return result
*/

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int result = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n - 2; i++) {
            if (nums[i + 2] - nums[i + 1] == nums[i + 1] - nums[i]) {
                if (i == 0) {
                    dp[i] = 1;
                } else {
                    dp[i] = 1 + dp[i - 1];
                }
                result += dp[i];
            }
        }
        return result;
    }
}