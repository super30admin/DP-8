// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
        
        int n = nums.length;
        int count = 0;
        int dp = 0;        
        
        for(int i = n - 3; i >= 0; i--) {
            if(nums[i + 1] - nums[i] == nums[i + 2] - nums[i + 1]) {
                dp+= 1;
                count += dp;
            } else {
                dp = 0;
            }
        }
        
        
        return count;
    }
}