// Time Complexity : The time complexity is O(n) where n is the length of the array
// Space Complexity : The space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {

    public int numberOfArithmeticSlices(int[] nums) {

        if(nums.length < 3){
            return 0;
        }

        int count = 0;
        int prev = 0;
        int n = nums.length;

        for(int i=2;i<n;i++){
            //if it forms a sequence
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                prev += 1;
                count += prev;
            }
            else{
                prev = 0;
            }
        }
        return count;
    }
}