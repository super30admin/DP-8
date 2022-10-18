//Time -O(n)
//Space - O(n)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i=0; i<nums.length;i++){
            dp[i]=0;
        }
        int n = nums.length;
        int sum =0;
        for(int i=2; i<n; i++){
            int diff = nums[i-2]-nums[i-1];
            if(nums[i-1]-nums[i] ==diff){
                dp[i] =dp[i-1] + 1;
            }
            
                sum+=dp[i];
            }
        
          
        return sum;
        
    }
}