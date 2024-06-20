// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//TC: O(N^2)
// SC: O(1)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int count =0;
        for(int i=0;i< n-2;i++){
            int diff = nums[i+1] - nums[i];
            for(int j=i+2;j<n;j++){
                if(nums[j] - nums[j-1] == diff){
                    count++;
                }else{
                    break;
                }
            }
        }
        return count;
    }
}

//TC: O(N)
//SC : O(N)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int count=0;
        int[] dp = new int[n];

        for(int i=2;i< n;i++){
            if((nums[i] - nums[i-1]) == (nums[i-1] - nums[i-2])){
                dp[i] = dp[i-1] +1;
                count += dp[i];
            }
        }

        return count;
    }
}