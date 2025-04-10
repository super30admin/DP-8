/*
 * TC: O(n)
 * SC: O(1)
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        // the number of slices that can be formed starting at the current index
        int currSlices = 0;
        int sum = 0;
        for(int i = n - 3; i >= 0; i--) {
            // if this subarray forms (a) slice(s), increment currSlices
            if(nums[i + 1] - nums[i] == nums[i + 2] - nums[i + 1]) {
                currSlices++;
            }
            // else reset currSlices
            else {
                currSlices = 0;
            }
            // add currSlices to the net total slices
            sum += currSlices;
        }
        return sum;
    }
}
