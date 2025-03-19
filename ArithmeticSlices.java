class Solution {
    //Time Complexity:O(n)
    //Space Complexity:O(n)
    public int numberOfArithmeticSlices(int[] nums) {
    if (nums.length < 3)
    return 0;

        int[] dp = new int [nums.length];
        int count = 0;
        for (int i =nums.length-3;i >= 0; i--){
            if (nums[i+2] - nums[i+1] == nums[i+1] - nums[i]){
                dp[i] = 1+ dp[i+1];
            }
            count = count + dp[i];
        }
        return count;
    }
}
