// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
Check if the difference between current element and previous element is equal to the previous and before previous
element's difference, if so, we increment the slice and increase count. If not, we intialize the curr back to
0 and count remains unchanged, Lastly, we return the count.
 */
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0;
        int curr = 0;
        for(int i = 2 ; i < nums.length ; i++) {
            if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2])
                curr = curr + 1;
            else
                curr = 0;
            count += curr;
        }
        return count;
    }
}