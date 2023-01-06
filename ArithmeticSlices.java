// Brute Force method
// TC - O(n^2)
// SC - O(1)
class Solution {

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            int diff = nums[i + 1] - nums[i];
            for (int j = i + 2; j < n; j++) {
                if (nums[j] - nums[j - 1] == diff) {
                    count++;
                } else break;
            }

        }
        return count;
    }
}

// 2 Pointer approach
// TC - O(n)
// SC - O(1)
class Solution {

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int sum = 0, prev = 0, curr = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                curr = prev + 1;
                sum += curr;
            } else {
                curr = 0;
            }
            prev = curr;
        }
        return sum;
    }
}

// DP Approach 1
// TC - O(n)
// SC - O(n)
class Solution {

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        int sum = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                sum += dp[i];
            }
        }
        return sum;
    }
}

// DP Approach 2
// TC - O(n)
// SC - O(n)

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        int sum = 0;
        for (int i = n - 3; i >= 0; i--) {
            if (nums[i + 1] - nums[i] == nums[i + 2] - nums[i + 1]) {
                dp[i] = dp[i + 1] + 1;
                sum += dp[i];
            }
        }
        return sum;
    }
}