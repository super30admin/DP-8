class Solution {
    //tc- o(n) sc-o(n)
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length ==0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        int sum=0;
        for(int i=n-3;i>=0;i--)
        {
            if(nums[i+1] - nums[i] == nums[i+2]-nums[i+1])
            {
                dp[i] = dp[i+1] +1;
                sum+= dp[i];
            }
        }
         return sum;
    }
}


class Solution {
    //tc- o(n) sc-o(n)
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length ==0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        int sum=0;
        for(int i=2;i<n;i++)
        {
            if(nums[i] - nums[i-1] == nums[i-1]-nums[i-2])
            {
                dp[i] = dp[i-1] +1;
                sum+= dp[i];
            }
        }
         return sum;
    }
}