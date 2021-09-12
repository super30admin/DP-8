//Time: O(N)
//Space: O(1)


//This is the top down dp approach
class arithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length < 3)
            return 0;
        
        int n = nums.length;
        int[] dp = new int[n];
        int sum = 0;
        
        for(int i = 2; i < n; i++){
            if(nums[i] - nums[i - 1] == nums[i - 1]- nums[i - 2]){
                dp[i] = dp[i-1] + 1;
            }
            sum += dp[i];
        }
        
        return sum;
    }
}