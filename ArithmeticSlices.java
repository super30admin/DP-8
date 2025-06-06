// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int count = 0; 
        int curr = 0;

        for(int i = 2; i < n; i++) {
            if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                curr = curr + 1;
            } else {
                curr = 0;
            }
            count += curr;
        }

        return count;
    }
}
