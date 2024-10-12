// Problem 413. Arithmetic Slices
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        int[] dp = new int[nums.length];
        int totalSlices = 0;
        for(int i = 2; i < nums.length; i++) {
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]){
                dp[i] = dp[i-1] + 1;
                totalSlices += dp[i];
            }
        }
        return totalSlices;
    }
}
