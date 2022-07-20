// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

//we are maintaining a dp array as ap will continue after 3 elements also
// and no of AP will increase. At the end, we'll return the toatal count
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if ((nums[i] - nums[i - 1]) == (nums[i - 1] - nums[i - 2])) {
                dp[i] = dp[i - 1] + 1;
                count += dp[i];
            }

        }
        return count;
    }
}

// --------------USING VARIABLES------------------------------------
// Time Complexity :O(n)
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No
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