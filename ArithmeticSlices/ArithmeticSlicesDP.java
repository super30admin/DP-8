/* Time Complexity : O(n)
 *   n - length of the input array */
/* Space Complexity : O(n) */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//DP

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
        if(nums == null || nums.length ==0){
            return 0;
        }

        int n = nums.length;
        int dp[] = new int[n];
        int count = 0;
        for(int i = 2; i < n; i++){
           if(nums[i] - nums[i-1] == nums[i -1] - nums[i-2]){
            dp[i] = dp[i-1] + 1;
            count += dp[i];
           }
        }
        return count;
    }
}