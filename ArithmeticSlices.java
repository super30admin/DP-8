// DP TC = O(n) solution SC = O(1) using 1 variables
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int secondLast = 0;
        int sum = 0;
        // n-1 is the last element hence n-3 is the 3rd last element
        for(int i=n-3;i>=0;i--){
            
            if(nums[i]-nums[i+1] == nums[i+1]-nums[i+2]){ 
                secondLast = 1 + secondLast; 
            }else{
                secondLast = 0;
            }
            sum = sum + secondLast;
        }
        return sum; // sum is the sum of all elements of the dp array
    }
}

// DP TC = O(n) solution SC = O(n);
// class Solution {
//     public int numberOfArithmeticSlices(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n];
//         int sum = 0;
//         // n-1 is the last element hence n-3 is the 3rd last element
//         for(int i=n-3;i>=0;i--){
//             if(nums[i]-nums[i+1] == nums[i+1]-nums[i+2]){
//                 dp[i] = 1 + dp[i+1]; 
//                 sum = sum + dp[i];
//             }
//         }
//         return sum; // sum is the sum of all elements of the dp array
//     }
// }


// Brute Force TC = O(n^2) solution
// class Solution {
//     public int numberOfArithmeticSlices(int[] nums) {
//         int n = nums.length;
//         int result = 0;
//         for(int i=0;i<n-2;i++){
//              int diff = nums[i+1] - nums[i]; //difference between 2 elements from start of slice
//             for(int j=i+1;j<n-1;j++){
               
//                 if(diff == nums[j+1] - nums[j]){
//                     result++;
//                 }else{
//                     break;
//                 }
//             }
//         }
//         return result;
//     }
// }