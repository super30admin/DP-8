// Time Complexity : O(N) 
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    1. Keep looping through and see if the three pairs are possible.
    2. If yes add 1 to the previous count since we can form one more pair.
    3. If no, then we put 0.
*/


// Your code here along with comments explaining your approach
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int[] dp = new int[len];
        for(int i=2;i<len;i++) {
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                dp[i] = dp[i-1] + 1;
                sum += dp[i];
            }
        }
        return sum;
    }
}
