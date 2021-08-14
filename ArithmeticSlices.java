// Time Complexity : O(n)
// Space Complexity :O(n) //can reduce to O(1) by using variables
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int[] dp= new int[nums.length];
        int sum=0;
        for(int i=2;i<nums.length;i++){
            if(nums[i-2]-nums[i-1]==nums[i-1]-nums[i]){
                dp[i]=dp[i-1]+1;
                sum+=dp[i];
            }
        }
        return sum;
    }
}