// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
         if(nums == null || nums.length == 0) return 0;
        
          int[] dp = new int[nums.length];
        
        
        for(int i=2;i<nums.length;i++)
        {
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2])
            {
                if(dp[i-1]==0)
                    dp[i]=3;
                else
                    dp[i]=dp[i-1]+1;
            }
            else
            {
                dp[i]=0;
            }
        }
        
        int sum=0;
        
        for(int j=0;j<nums.length;j++)
        {
            if(dp[j]!=0)
            {
                sum+=dp[j]-3+1;
            }
        }
        
        return sum;
    }
}