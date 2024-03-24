/*Time Complexity: O(N)

Space Complexity: O(N)

Did this code successfully run on Leetcode : Yes

Approach: Tabulation - Bottom up

Prob: 413. Arithmetic Slices
*/

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int count = 0;
        int [] dp = new int[n];
        for(int i=n-3;i>=0;i--){
           if(nums[i+2] - nums[i+1] == nums[i+1] - nums[i]){
            dp[i] = 1 + dp[i+1];
           }
           count += dp[i];
        }
        return count;
    }
}