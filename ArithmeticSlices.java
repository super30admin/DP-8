// Time Complexity : 1 - O(n^2), 2 - O(n)
// Space Complexity : 1- O(1), 2 - O(n)

// Method - 1
/*class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3) return 0;
        int n = nums.length;
        int count = 0;
        for(int i = 0; i<n-2; i++) {
            int diff = nums[i+1] - nums[i];
            for(int j = i+1; j<n-1; j++) {
                if(nums[j+1]-nums[j] == diff) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}*/

// Method - 2
class Solution {
  public int numberOfArithmeticSlices(int[] nums) {
    if(nums.length < 3) return 0;
    int n = nums.length;
    int[] dp = new int[n];
    int count = 0;
    for(int i = n-3; i>=0; i--) {
      if(nums[i+2]-nums[i+1] == nums[i+1]-nums[i]) {
        dp[i] = 1+dp[i+1];
      }
      count += dp[i];
    }
    return count;
  }
}