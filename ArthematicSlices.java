//Time complexity is O(N)
//Space complexity is O(N)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3){
            return 0;
        }
        int[] dp=new int[nums.length];
        dp[1]=2;
        int prev = nums[1]-nums[0];
        int result = 0;
        for(int i=2;i<nums.length;i++){
            int diff = nums[i]-nums[i-1];
            if(prev==diff){
                dp[i]=dp[i-1]+1;
            }
            else{
                int n =dp[i-1]-2;
                if(n>=1){
                    result = result+ (n*(n+1))/2;
                }
                n=2;
                prev=diff;
                dp[i]=2;
            }
        }
        int m =dp[nums.length-1]-2;
        if(m>=1){
            result = result+ (m*(m+1))/2;
        }
        return result;
    }
}