// Time Complexity: O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        // null
        if(nums == null || nums.length == 0) return 0;
        int count = 0;
        int n = nums.length;
        int prev = 0;
        // int[] dp = new int[n];
        for(int i = 2; i < n; i++) {
            int curr = 0;
            if(nums[i-1] - nums[i-2] == nums[i] - nums[i-1]) {
                curr = prev + 1;
                count += curr;
            }
            prev = curr;
        }
        return count;
    }
}
