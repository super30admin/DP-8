// // ******************** DP 1D ********************

// Time Complexity:  O(n)
// Space Complexity: O(n)

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int count = 0;
        if(n < 3) return count;
        int curr = 0;
        for(int i=n-3; i>=0; i--) {
            if(nums[i+2] - nums[i+1] == nums[i+1] - nums[i]) {
                curr++;
                count += curr;
            }
            else {
                curr = 0;
            }
        }
        return count;
    }
}

// // ******************** DP array ********************

// // Time Complexity:  O(n)
// // Space Complexity: O(n)

// class Solution {
//     public int numberOfArithmeticSlices(int[] nums) {
//         int n = nums.length;
//         int count = 0;
//         if(n < 3) return count;
//         int dp[] = new int[n];
//         for(int i=n-3; i>=0; i--) {
//             if(nums[i+2] - nums[i+1] == nums[i+1] - nums[i])
//                 dp[i] = dp[i+1]+1;
//         }
//         for(int d : dp)
//             count += d;
//         return count;
//     }
// }



// // ******************** Brute Force ********************
// // Time Complexity:  O(n^2)
// // Space Complexity: O(1)

// class Solution {
//     public int numberOfArithmeticSlices(int[] nums) {
//         int n = nums.length;
//         int count = 0;
//         if(n < 3) return count;
//         for(int i=0; i<n-2; i++) {
//             int diff = nums[i+1] - nums[i];
//             for(int j=i+1; j<n-1; j++) {
//                 if(nums[j+1] - nums[j] == diff)
//                     count++;
//                 else 
//                     break;
//             }
//         }
//         return count;
//     }
// }
