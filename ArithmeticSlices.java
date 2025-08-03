class Solution {
  public int numberOfArithmeticSlices(int[] nums) {
    int n = nums.length;
    int sum = 0;
    int curr = 0;
    for(int i = n-3 ; i >= 0 ; i--){
      if(nums[i+1]-nums[i] == nums[i+2]-nums[i+1]){
        curr+=1;
        sum = sum +curr;
      }
      else{
        curr = 0;
      }
    }
   
     return sum;
        
  }
}

// class Solution {
//   public int numberOfArithmeticSlices(int[] nums) {
//     int n = nums.length;
//     int[] dp = new int[n];
//     int sum = 0;
//     for(int i = n-3 ; i >= 0 ; i--){
//       if(nums[i+1]-nums[i] == nums[i+2]-nums[i+1]){
//         dp[i] = 1 + dp[i+1];
//       }
//     }
//     for(int num : dp){
//       sum = sum + num;
//     }
//      return sum;
        
//   }
// }