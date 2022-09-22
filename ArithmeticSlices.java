// Time Complexity : O(n) n is the length
// Space Complexity : O(n) length of dp array. Can be done in O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0;
        int n = nums.length;
        int [] dp = new int[n];
        for(int i=2;i<n;i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                dp[i]=dp[i-1]+1;
                count+=dp[i];
            }
        }

        return count;
    }
}