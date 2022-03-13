// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        int sum = 0;
        int[] dp = new int[nums.length];

        for(int i = 2; i < nums.length; i++){
            //check if diff of consecutive numbers are equal
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                dp[i] = dp[i-1] + 1;
                sum+= dp[i];
            }
        }
        return sum;
    }
}
