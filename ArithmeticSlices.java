// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

//Using bottom up - tabulation - optimising space
class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        //int[] dp = new int[n];
        int curr = 0;
        int count = 0;
        for (int i = n-3; i >= 0; i--) { // 1,2,3,4,5,9,10,11,12
            if (nums[i + 2] - nums[i + 1] == nums[i + 1] - nums[i]) {
                curr = 1 + curr;
            } else {
                curr = 0;
            }
            count += curr;
        }
        return count;
    }
}