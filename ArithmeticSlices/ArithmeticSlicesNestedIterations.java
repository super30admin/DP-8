/* Time Complexity : O(n^2)
 *   n - length of the input array */
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Nested iterations

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
        if(nums == null || nums.length ==0){
            return 0;
        }

        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n-2; i++){
            int diff = nums[i+1] - nums[i];
            for(int j = i + 2; j < n; j++){
                if(diff == nums[j] - nums[j-1]){
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}