// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int count = 0;
        int n = nums.length;
        int curr = 0;
        int next = 0;

        for (int i = n - 3; i >= 0; i--) {
            if (nums[i] - nums[i + 1] == nums[i + 1] - nums[i + 2]) {
                curr = next + 1;
                count += curr;
            } else {
                curr = 0;
            }
            next = curr;

        }
        return count;
    }
}