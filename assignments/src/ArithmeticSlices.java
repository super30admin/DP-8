// Approach: Bottom up Dp
// Time: O(n)
// Space: O(1)

class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length == 0) return 0;
        int n = nums.length;
        int sum = 0;
        int next = 0;
        int curr = 0;

        for (int i = n-3; i>=0; i--) {
            if (nums[i+2] - nums[i+1] == nums[i+1] - nums[i]) {
                curr = next + 1;
                sum += curr;
                next = curr;
            }
            else next = 0;
        }
        return sum;
    }
}