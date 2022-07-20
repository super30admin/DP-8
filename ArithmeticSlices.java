public class ArithmeticSlices {
    class Solution {
        // Time Complexity : O(N^2), N = #numsLength
        // Space Complexity : O(1)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        public int numberOfArithmeticSlices1(int[] nums) {
            if(nums == null || nums.length == 0) return 0;
            int n = nums.length;
            int count = 0;
            for(int i = 0; i<n-2; i++) {
                int diffBetweenFirst2Nums = nums[i+1] - nums[i];
                for(int j=i+2; j<n; j++) {
                    int diffBetweenLast2Nums = nums[j] - nums[j-1];
                    if(diffBetweenFirst2Nums == diffBetweenLast2Nums) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
            return count;
        }
        // Time Complexity : O(N), N = #numsLength
        // Space Complexity : O(N)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        public int numberOfArithmeticSlices2(int[] nums) {
            if(nums == null || nums.length == 0) return 0;
            int n = nums.length;
            int count = 0;
            int[] dp = new int[n];
            for(int i = n-3; i >= 0; i--) {
                if(nums[i+2] - nums[i+1] == nums[i+1] - nums[i]) {
                    dp[i] = 1 + dp[i+1];
                    count += dp[i];
                }
            }
            return count;
        }

        // Time Complexity : O(N), N = #numsLength
        // Space Complexity : O(N)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        public int numberOfArithmeticSlices3(int[] nums) {
            if(nums == null || nums.length == 0) return 0;
            int n = nums.length;
            int count = 0;
            int prev = 0;
            for(int i = 2; i < n; i++) {
                int curr = 0;
                if(nums[i-1] - nums[i-2] == nums[i] - nums[i-1]) {
                    curr = 1 + prev;
                    count += curr;
                }
                prev = curr;
            }
            return count;
        }
    }
}
