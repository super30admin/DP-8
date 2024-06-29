// Time Complexity : O(n)
// Space Complexity : O(n)
// Method used : DP

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];

        // Bcoz the slices should be atleast of size 3
        if(n < 3) return 0;

        for(int i = 2; i < n; i++)
        {
            // Assume we have array as 1, 3, 5, 7 and dp array looks like 0, 0, 1, 2. Now this 2 indicates that we have 2 
            // sub arrays which are 1, 3, 5, 7 and the previous subarray which we considered from dp[i - 1] which is 1, 3, 5
            if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) dp[i] = 1 + dp[i - 1];
        }

        // We are traversing to find the sum at all indices this is bcoz in the above explanation when the value was 2 we considered
        // subarrays 1, 3, 5, 7 and 1, 3, 5 but we never considered 3, 5, 7 which is also a valid subarray. That's why we add 1 + 2 = 3
        // So in total we have 3 subarrays at the end
        int sum = 0;

        for(int i = 0; i < n; i++) sum += dp[i];

        return sum;
    }
}
