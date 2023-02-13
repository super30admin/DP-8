// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class ArithmeticSlice {

        public int numberOfArithmeticSlices(int[] nums) {
            int count =0;
            //int[] dp = new int[nums.length];
            int prev = 0;
            for (int i=2;i<nums.length;i++){
                if (nums[i]-nums[i-1] == nums[i-1]-nums[i-2]){
                    //dp[i] = 1+ dp[i-1];
                    prev = prev+1;
                    count += prev;
                }else {
                    prev = 0;
                }
            }
            return count;
        }
    
    
}
