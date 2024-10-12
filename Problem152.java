//TC: O(n)
//SC: O(n)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        
        // DP array to store number of arithmetic slices ending at each index
        int[] dp = new int[n];
        int totalSlices = 0;
        
        // Start from the third element and check if it forms an arithmetic sequence
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                dp[i] = dp[i-1] + 1;
                totalSlices += dp[i]; // Add to the total number of slices
            }
        }
        
        return totalSlices;
    }
}
