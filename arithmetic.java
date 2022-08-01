// Time Complexity :O(n)
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        // int[] dp=new int[n];
        int count = 0;
        int prev = 0;
        int curr = 0;
        for (int i = 2; i < n; i++) {
            if ((nums[i] - nums[i - 1]) == (nums[i - 1] - nums[i - 2])) {
                // dp[i]=dp[i-1]+1;
                curr = prev + 1;
                count += curr;
                prev = curr;
            } else {
                prev = 0;
            }

        }
        return count;
    }
}