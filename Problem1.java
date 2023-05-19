//Time -> O(n)
//Space -> O(n)
class Problem1 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length; 
        int dp[] = new int[n];
        int sum = 0;
        for(int i = n - 3; i >= 0; i--){
            if(nums[i+2] - nums[i+1] == nums[i+1]- nums[i]){
                dp[i] = dp[i+1] + 1;
            }
            sum += dp[i];
        }
        return sum;
    }
}