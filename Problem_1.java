// Time Complexity : O(n*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// take the difference between the three and compare all, if found same then increase the count by 1 of the previous dp array, for varuable set the previous variable and set it to zero if diff is not same
// Your code here along with comments explaining your approach
// Using DP - top-down with linear Space
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if( nums == null || nums.length < 3) return 0;
        int curr = 0; int prev = 0; int count = 0;
        for(int i = 1; i < nums.length-1; i++){
            if( nums[i] - nums[i-1] == nums[i+1] - nums[i]){
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

// // bottom - up DP - O(n) & O(n)
// class Solution {
//     public int numberOfArithmeticSlices(int[] nums) {
//         if( nums == null || nums.length < 3) return 0;
//         int [] dp = new int[nums.length];
//         int count = 0;
//         for(int i = 1; i < nums.length-1; i++){
//             if( nums[i] - nums[i-1] == nums[i+1] - nums[i]){
//                 dp[i] = dp[i-1] + 1;
//                 count += dp[i];
//             }
//         }
//         return count;
//     }
// }

// // using bottom up - dp - O(n) & O(n)
// class Solution {
//     public int numberOfArithmeticSlices(int[] nums) {
//         if( nums == null || nums.length < 3 ) return 0;
//         int [] dp = new int [nums.length];
//         int count = 0;
//         for( int i = nums.length-2; i > 0; i--){
//             if(nums[i+1] - nums[i] == nums[i] - nums[i-1]){
//                 dp[i] = dp[i+1] + 1;
//                 count += dp[i];
//             }
//         }
//         return count;
//     }
// }

// m * n sol - brute force
// class Solution {
//     public int numberOfArithmeticSlices(int[] nums) {
//         if(nums == null || nums.length < 3) return 0;
//         int count = 0;
//         int n = nums.length;
//         for(int i = 0; i < n-2; i++){
//             int diff = nums[i+1] - nums[i];
//             for(int j = i+1 ; j < n-1; j++){
//                 if(nums[j+1] - nums[j] == diff) count ++;
//                 else break;
//             }
//         }
//         return count;
//     }
// }