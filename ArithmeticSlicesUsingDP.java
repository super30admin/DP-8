// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

public class ArithmeticSlicesUsingDP {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int result = 0;

        for(int i=2; i<n; i++){
            if(nums[i] - nums[i-1] == nums[i-1]-nums[i-2]){
                dp[i] = dp[i-1] + 1;
                result += dp[i];
            }
        }

        /*
        for(int i=n-3; i>=0; i--){
            if(nums[i+1] - nums[i] == nums[i+2]-nums[i+1]){
                dp[i] = dp[i+1] + 1;
                result += dp[i];
            }
        }*/

        return result;
    }
}
