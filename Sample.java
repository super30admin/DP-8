## Problem1 Arithmetic Slices (https://leetcode.com/problems/arithmetic-slices/)

// Time Complexity - 0(n)
// Space Complexity - 0(n)

# Solution 1

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        
        int[] dp = new int[n];
        int count = 0;
        
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                dp[i] = dp[i-1] + 1;
                count += dp[i];
            }
        }
        
        return count;
    }
}

# Solution 2
// Time Complexity - 0(n)
// Space Complexity - 0(1)

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int count = 0;
        int prev = 0;
        int n = nums.length;

        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                prev = prev + 1;
                count = count + prev;
            }
            else {
                prev = 0;
            }
        }
        return count;
    }
}



## Problem 2 Triangle (https://leetcode.com/problems/triangle/)

// Time Complexity - 0(m * n)
// Space Complexity - 0(1)

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int n = triangle.size();

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i - 1).get(j));
                }
                else if (j == i) {
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i - 1).get(j - 1));
                }
                else {
                    triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1)));
                }
            }
        }
        int min = Integer.MAX_VALUE;

        for (int j = 0; j < triangle.get(n - 1).size(); j++) {
            min = Math.min(min, triangle.get(n - 1).get(j));
        }
        return min;
    }
}