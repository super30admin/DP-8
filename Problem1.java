//Time = O(n), length of input array
//Space = O(1)

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0; // there must be at least 3 numbers for arithmetic slice
        int count = 0;
        int curr = 0; // current count of arithmetic slices
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                curr++; // extend the current arithmetic slice
                count += curr; // add the count to the total count
            } else {
                curr = 0; // reset the current count
            }
        }
        return count;
    }
}
