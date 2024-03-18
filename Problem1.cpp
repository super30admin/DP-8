
//Time Complexity: O(N)
class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        if(nums.empty()) return 0;

        int n = nums.size();
        int count = 0;

        vector<int> dp(n, 0);

        for(int i = n - 3; i >= 0; i--) {
            if(nums[i + 2] - nums[i + 1] == nums[i + 1] - nums[i]) {
                dp[i] = 1 + dp[i + 1];
            }
            count += dp[i];
        }
        return count;
    }
};



// class Solution {
//     //Time Complexity: O(N*N)
// public:
//     int numberOfArithmeticSlices(vector<int>& nums) {
//         if(nums.empty()) return 0;

//         int n = nums.size();
//         int count = 0;

//         for(int i = 0; i < n - 2; i++) {
//             int diff = nums[i + 1] - nums[i];
//             for(int j = i + 2; j < n; j++) {
//                 if(nums[j] - nums[j - 1] == diff) {
//                     count++;
//                 } else {
//                     break;
//                 }
//             }
//         }
//         return count;
//     }
// };