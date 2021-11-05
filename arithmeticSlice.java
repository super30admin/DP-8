// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Space optimized!
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        // null
        if(nums == null || nums.length == 0) return 0;
        
        int sum = 0; int n = nums.length; 
        int curr = 0;
        // int [] dp = new int[n];
        
        for(int i=2; i< n; i++){
            if((nums[i] - nums[i-1]) == (nums[i-1] - nums[i-2])){
                // dp[i] = dp[i-1] + 1;
                curr++;
                sum += curr;
            } else{
                curr = 0;
            }
        }
        return sum;
    }
}

// *******************************************
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Top down DP approach
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        // null
        if(nums == null || nums.length == 0) return 0;
        
        int sum = 0; int n = nums.length;
        int [] dp = new int[n];
        
        for(int i=2; i< n; i++){
            if((nums[i] - nums[i-1]) == (nums[i-1] - nums[i-2])){
                dp[i] = dp[i-1] + 1;
                sum += dp[i];
            }
        }
        return sum;
    }
}

// ******************************************

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Bottom up DP approach
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        // null
        if(nums == null || nums.length == 0) return 0;
        
        int sum = 0; int n = nums.length;
        int [] dp = new int[n];
        
        for(int i=n - 3; i>=0; i--){
            if((nums[i+2] - nums[i+1]) == (nums[i+1] - nums[i])){
                dp[i] = dp[i+1] + 1;
                sum += dp[i];
            }
        }
        return sum;
    }
}

// ******************************************
// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// O(n^2) approach
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        // null
        if(nums == null || nums.length == 0) return 0;
        
        int count = 0; int n = nums.length;
        for(int i=0; i < n - 2; i++){
            int diff = nums[i+1] - nums[i];
            for(int j=i+1; j<n-1; j++){
                if( (nums[j+1] - nums[j]) == diff){
                    // increment count
                    count++;
                } else{
                    break;
                }
            }
        }
        return count;
    }
}