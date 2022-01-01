// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length <= 2) return 0;
        int prev = 0; int sum = 0;
        for(int i = nums.length-3; i >= 0; i--){
            if(nums[i+2] - nums[i+1] == nums[i+1]- nums[i]){
                prev += 1;// Inc. prev 
                sum += prev;// Add prev to sum 
                
            }
            else
            {
                prev = 0;// Reset prev = 0 , if it is not a subarray.
            }
        }
        return sum;
    }
}

