class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;
        int[] dp = new int[nums.length];

        for(int i=2; i<nums.length; i++) {
            int diff1 = nums[i-1] - nums[i-2];
            int diff2 = nums[i] - nums[i-1];
            if(diff1 == diff2) {
                dp[i] = dp[i-1] + 1;
                count += dp[i];
            }
        }

        return count;
    }
}
