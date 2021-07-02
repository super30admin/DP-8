// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length == 0 ) return 0;
        int result = 0;
        int prev = 0;
        for(int i = 2 ; i < nums.length ; i++){
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                prev++;
                result += prev;
            }else{
                prev = 0;
            }
            
        }
        return result;
    }
}
