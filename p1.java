// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int result = 0;
        int prev = 0;
        //Go over each and every element
        for(int i=2; i<nums.length; i++){
            //If we find the slice, increment prev and add it to result
            if(nums[i-1] - nums[i-2] == nums[i] - nums[i-1]){
                prev++;
                result = result + prev;
            }
            else{
                //Else make prev equal to zero
                prev = 0;
            }
        }
        return result;
    }
}