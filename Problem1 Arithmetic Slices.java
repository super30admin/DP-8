//O(N) time and spcae complexity with dp solution

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        int count = 0;
        int [] dp = new int[n];
        for(int i=2;i<n;i++){
             if (nums[i-1] - nums[i-2] == nums[i]-nums[i-1]){
                 dp[i] = 1 + dp[i-1];
                 count += dp[i];
             }      
            }
        return count;
    }
}
