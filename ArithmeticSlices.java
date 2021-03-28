// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started

// Your code here along with comments explaining your approach
public class ArithmeticSlices {
    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            int result = 0;
            int count = 0;
            //initialize at 2 since we need 3 numbers and then perform dp calculation
            for (int i = 2; i < nums.length; i++) {
                if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                    count++;
                    result +=count;
                }else{
                    count = 0;
                }
            }
            return result;
        }
    }
}
