class ArithmeticSlice {
  /**
    When (nums[i] - nums[i-1]) = (nums[i-1] - nums[i-2]),
    
    The number of slices possible at dp[i] is 
      the number of slices possible at dp[i-1] + 1
    
    Time Complexity: O(n)
    Space Complexity: O(1)
    
    Were you able to solve this on leetcode? YES
    */
    public int numberOfArithmeticSlices(int[] nums) {
        
      int result = 0;
      int[] dp = new int[nums.length];
      for(int i = 2; i < nums.length; i++){
          if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
              dp[i] = dp[i-1] + 1;
          }
          result += dp[i];
      }
      
      return result;
  }
}
