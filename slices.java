// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
 * Start from index 2 and check if there is a possible slice at each index. If there is a valid slice add 1 to previous value to current index.
 * Also keep track of the whole sum while doing above step.
 */
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int result = 0;
        
        for(int i=2; i<n;i++){
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                dp[i] = 1 + dp[i-1];
            }
            result += dp[i];
        }

        return result;
    }
}
