/*
Time Complexity: O(n)
Space Complexity: O(n)
*/
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int len=1;
        int n=nums.length;
        if(n<3){
            return 0;
        }
        int diff=Integer.MAX_VALUE;
        int[] dp=new int[n];
        dp[0]=0;
        for(int i=1;i<n;i++){
            len++;
            if(len==2){
                diff=nums[i]-nums[i-1];
                dp[i]=0;
            }
            else{
                if(nums[i]-nums[i-1]==diff){
                    dp[i]=dp[i-1]+1;
                }
                else{
                    len=2;
                    dp[i]=0;
                    diff=nums[i]-nums[i-1];
                }
            }
        }
        int res=0;
        for(int elt:dp){
            res+=elt;
        }
        return res;
    }
}