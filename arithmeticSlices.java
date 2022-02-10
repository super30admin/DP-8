// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// DP solution with dp array of size n
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
        if (nums == null || n < 3) return 0;

        int[] dp = new int[n];
        int count = 0;

        for (int i=2; i<n; i++) {
            if (nums[i]-nums[i-1] == nums[i-1]-nums[i-2]) {
                dp[i] = dp[i-1]+1;
                count += dp[i];
            }
        }

        return count;
    }
}

// --------------------------------- Space Optimized approach ---------------------------------
// Time Complexity : O(n)
// Space Complexity : O(1)
// DP solution with O(1) space
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 3) return 0;

        int prev = 0;
        int count = 0;

        for (int i=2; i<nums.length; i++) {
            if (nums[i]-nums[i-1] == nums[i-1]-nums[i-2]) {
                prev += 1;
                count += prev;
            }
            else {
                prev = 0;
            }
        }

        return count;
    }
}