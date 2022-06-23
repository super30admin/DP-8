public class Problem1 {

    //bruteforce solution
    // TC : O(n^2)
    // SC : O (1)
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (nums[j] - nums[j - 1] == nums[j + 1] - nums[j]) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    // DP solution with array
    // TC : O(n)
    // SC : O(n)
    public int numberOfArithmeticSlices1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] dp = new int[n];
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            count = count + dp[i];
        }

        return count;
    }

    // DP Solution with O(1) space
    // TC : O(n)
    // SC : O(1)
    public int numberOfArithmeticSlices2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int prev = 0;
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                prev = prev + 1;
                count = count + prev;
            } else {
                prev = 0;
            }
        }
        return count;
    }
}
