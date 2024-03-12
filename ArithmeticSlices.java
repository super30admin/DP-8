public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        // return numberOfArithmeticSlicesDPWithSpace(nums);
        // return numberOfArithmeticSlicesDPWithoutSpace(nums);
        return numberOfArithmeticSlicesBruteForce(nums);
    }

    // TC: O(N) where N is length of nums
    // SC: O(1)
    private int numberOfArithmeticSlicesDPWithoutSpace(int[] nums) {
        int n = nums.length;
        int res = 0;
        int prev = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                int curr = prev + 1;
                res += curr;
                prev = curr;
            } else {
                prev = 0;
            }
        }
        return res;
    }

    // TC: O(N) where N is length of nums
    // SC: O(N) where N is length of nums
    private int numberOfArithmeticSlicesDPWithSpace(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int res = 0;
        for (int i : dp) {
            res += i;
        }
        return res;
    }

    // TC: O(N * N) where N is length of nums
    // SC: O(1)
    private int numberOfArithmeticSlicesBruteForce(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            int diff = nums[i + 1] - nums[i];
            for (int j = i + 2; j < n; j++) {
                if (nums[j] - nums[j - 1] == diff) {
                    res++;
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
