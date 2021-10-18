//TC: O(n)
//SC: O(n)
//running on leetcode:yes
//going from right end of the given array
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums==null || nums.length<3) return 0;
        int total=0;
        int n=nums.length;
        int[] dp = new int[n];
        for(int i=n-3; i>=0; i--){
            if(nums[i] - nums[i+1] == nums[i+1]- nums[i+2]){
                dp[i]=dp[i+1]+1;
            }
            total += dp[i];
        }
        return total;
    }
}
