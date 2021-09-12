//Time: O(N)
//Space: O(1)

//This is the dp bottom up approach
class arithSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length < 3)
            return 0;
        
        int n = nums.length;
        int[] dp = new int[n];
        int sum = 0;
        
        for(int i = n - 3; i >= 0; i--){
            if(nums[i+2] - nums[i+1] == nums[i + 1]- nums[i]){
                dp[i] = dp[i+1] + 1;
            }
            sum += dp[i];
        }
        
        return sum;
    }
}