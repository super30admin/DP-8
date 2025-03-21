//Time Complexity - O(n)
//Space Complexity - O(1)
class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }

        int n = nums.length;
        int count = 0;
        int prev = 0;
        for (int i = n - 2; i > 0; i--) {
            if (nums[i - 1] - nums[i] == nums[i] - nums[i+1]) {
                prev = prev + 1;
                count = count + prev;
            } else {
                prev = 0;
            }
        }
        return count;
    }
}
