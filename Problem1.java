public class Problem1 {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums==null||nums.length<3) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 0;
        int rsum = 0;
        for (int i=2;i<n;i++) {
            int diff = nums[i-1]-nums[i-2];
            if (nums[i]-nums[i-1]==diff) {
                dp[i] = dp[i-1]+1;
            }
            else dp[i] = 0;
            rsum+=dp[i];
        }
        return rsum;
    }
}