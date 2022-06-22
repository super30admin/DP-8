/*
Problem: https://leetcode.com/problems/arithmetic-slices/
*/

// Approach 1: brute force
// TC: O(n ^ 2)
// SC: O(1)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int slices = 0;
        
        for (int i = 0; i < n - 1; ++i) {
            int diff = nums[i + 1] - nums[i];
            for (int j = i + 1; j < n - 1; ++j) {
                if (nums[j + 1] - nums[j] == diff) {
                    ++slices;
                } else {
                    break;
                }
            }
        }
        
        return slices;
    }
}

// Approach 2: more efficient
// TC: O(n)
// SC: O(n)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        // Maintain #arthimetic slices until that index
        int dp[] = new int[n];
        
        for (int i = 2; i < n;++i) {
            if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                dp[i] = dp[i-1] + 1;
            }
        }
        
        int slices = 0;
        // Can calculate slices after line 46 to avoid this for loop
        for (int i = 0; i < n; ++i)
            slices += dp[i];
        return slices;
    }
}

// Approach 3: Space efficient
// TC: O(n), SC: O(1)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int prevSlices = 0;
        int slices = 0;
        
        for (int i = 2; i < n;++i) {
            if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                prevSlices = prevSlices + 1;
            } else {
                prevSlices = 0;
            }
            slices += prevSlices;
        }
        return slices;
    }
}
