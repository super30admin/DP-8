/* Time Complexity : O(n)
 *   n - length of the input array */
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
        if(nums == null || nums.length ==0){
            return 0;
        }

        int n = nums.length;
        int prev = 0;
        int curr = 0;
        int count = 0;
        for(int i = 2; i < n; i++){
           if(nums[i] - nums[i-1] == nums[i -1] - nums[i-2]){
            curr = prev + 1;
            count += curr;
           } else {
            curr = 0;
           }
           prev = curr;
        }
        return count;
    }
}