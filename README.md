# DP-8

## Problem1 Arithmetic Slices (https://leetcode.com/problems/arithmetic-slices/)
//Time Complexity = O(N)
//Space complexity = O(N)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length < 3) return 0;
        int[] dp = new int[nums.length];
        int sum = 0;
        int n = nums.length; 
        for(int i = 2; i < n; i++){
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                dp[i] = dp[i-1] + 1;
                sum = sum + dp[i]; 
            }
        }
        return sum; 
    }
}

## Problem 2 Triangle (https://leetcode.com/problems/triangle/)

//Time Complexity = O(N)
//Space Complexity = O(triangle.size())
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0) return 0; 
        int n = triangle.size();
        int[] dp = new int[n]; 
        
        for(int j = 0; j < dp.length; j++){
            dp[j] = triangle.get(n-1).get(j); 
        }
        
        for(int i = n - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]); 
            }
        }
        
        return dp[0];
    }
}
