// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class ArithmeticSlices {
    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            int n = nums.length;
            if(nums == null || n == 0)
                return 0;
        /*dp arr
        if diff btw 3 ele same then prev+1
        else 0 */

            int result = 0;
            int curr = 0;
            for(int i = 2; i < n; i++){
                if((nums[i] - nums[i-1]) == (nums[i-1] - nums[i-2])){
                    curr++;
                    result += curr;
                }
                else{
                    curr = 0;
                }
            }
            return result;
        }
    }
}
