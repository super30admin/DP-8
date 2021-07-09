// WITHOUT USING DP ARRAY
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length < 3) return 0;
        //int [] dp = new int [nums.length];
        int count = 0;
        int curr = 0;
        int prev = 0;
        
        for(int i = 2; i < nums.length; i++){
            if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]){
                curr = prev + 1;
                count += curr;
                prev = curr;
            }else{
                prev = 0;
            }
        }
        return count;
        
    }
}
//TIME COMPLEXITY = O(n)
//SPACE COMPLEXITY = O(1)

---------------------------------------------------------------------------------
  
//WITH USING DP ARRAY
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length < 3) return 0;
        int [] dp = new int [nums.length];
        int count = 0;
        
        for(int i = 2; i < dp.length; i++){
            if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]){
                dp[i] = dp[i - 1] + 1;
                count += dp[i];
            }
        }
        return count;
        
    }
}

//TIME COMPLEXITY = O(n)
//SPACE COMPLEXITY = O(n)
