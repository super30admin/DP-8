// approch 1
// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 2
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 3
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Main {
    // approch 1 brute force
    public static int numberOfArithmeticSlices1(int[] nums) {
        // null case
        if (nums == null || nums.length == 0)
            return 0;
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            // take the first diff at any particular index
            int diff = nums[i + 1] - nums[i];
            for (int j = i + 2; j < n; j++) {
                // if diff is same for further indexes we increase the count
                // else we break the loop and check for further
                if (diff == nums[j] - nums[j - 1]) {
                    count++;
                } else {
                    break;
                }
            }
        }
        // return count
        return count;
    }

    // approch 2 using dp array
    public static int numberOfArithmeticSlices2(int[] nums) {
        // null case
        if (nums == null || nums.length == 0)
            return 0;
        int count = 0;
        int n = nums.length;
        // dp array
        int[] dp = new int[n];
        // start from the end and check if diff is same for triplets
        // is same than update the dp array with 1 + dp[i+1]
        // and add into count;
        for (int i = n - 3; i >= 0; i--) {
            if (nums[i] - nums[i + 1] == nums[i + 1] - nums[i + 2]) {
                dp[i] = dp[i + 1] + 1;
            }
            count += dp[i];
        }
        return count;
    }

    // approch 3 dp without using dp array
    public static int numberOfArithmeticSlices3(int[] nums) {
        // null case
        if (nums == null || nums.length == 0)
            return 0;
        int count = 0;
        int n = nums.length;
        // dp array
        int curr = 0;
        int next = 0;

        // start from the end and check if diff is same for triplets
        // is same than update the current with next +1
        // and add into count else reset the current and update the next with current
        for (int i = n - 3; i >= 0; i--) {
            if (nums[i] - nums[i + 1] == nums[i + 1] - nums[i + 2]) {
                curr = next + 1;
                count += curr;
            } else {
                curr = 0;
            }
            next = curr;

        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4 };
        System.out.println(numberOfArithmeticSlices1(nums));
        System.out.println(numberOfArithmeticSlices2(nums));
        System.out.println(numberOfArithmeticSlices3(nums));

    }
}