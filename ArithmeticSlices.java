// Approach : Optimized BruteForce - Form the contiguous subarrays as we traverse the array
// Time : O(n^2)
// Space : O(1)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int diff = nums[i + 1] - nums[i];
            for (int j = i + 1; j < n - 1; j++) {
                if (nums[j + 1] - nums[j] == diff) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}

// Approach : DP
// Time : O(n)
// Space : O(n)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length ==0) return 0;
        int n = nums.length;
        int sum =0;
        int[] dp = new int[n+1];
        for(int i=2;i<nums.length;i++){
            if(nums[i-1] - nums[i-2] == nums[i] - nums[i-1]){
                dp[i] = dp[i-1] + 1;
                sum+=dp[i];
            }
        }
        return sum;
    }
}

// Approach : Optimation without DP Array
// Time : O(n)
// Space : O(1)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length ==0) return 0;
        int n = nums.length;
        int sum =0;
        int prev =0;
        int curr =0;
        for(int i=2;i<n;i++){
            if(nums[i-1] - nums[i-2] == nums[i] - nums[i-1]){
                curr = prev + 1;
                sum+=curr;
                prev = curr; 
            } else{
                // in DP every thing was zero so by default prev can get zero but here we have to manually set it
                prev =0;
            }
        }
        return sum;
    }
}