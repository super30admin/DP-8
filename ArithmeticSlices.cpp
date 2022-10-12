// Approach - N^2 solution
// Time Complexity - O(n^2)
// SPace Complexity - O(1)
// It runs on Leetcode!
// Problems Faced - No!
class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        int n = nums.size();
        int count = 0;
        for(int i = 0; i < n-2; i++){
            int diff = nums[i+1] - nums[i];
            for(int j = i+1; j < n-1; j++){
                if(nums[j+1] - nums[j] == diff)
                    count++;
                else break;
            }
        }
        return count;
    }
};

// Approach - DP
// Time Complexity - O(n)
// SPace Complexity - O(n)
// It runs on Leetcode!
// Problems Faced - No!
class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp(n, 0);
        int count = 0;
        for(int i = 0; i < n-2; i++){
            if(nums[i+1] - nums[i] == nums[i+2] - nums[i+1]){
                dp[i+1] = dp[i] + 1;
                count += dp[i+1];
            }
        }
        return count;
    }
};

// Approach - Space Optimized DP
// Time Complexity - O(n)
// SPace Complexity - O(1)
// It runs on Leetcode!
// Problems Faced - No!
class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        int n = nums.size();
        int curr = 0;
        int count = 0;
        for(int i = 0; i < n-2; i++){
            if(nums[i+1] - nums[i] == nums[i+2] - nums[i+1]){
                curr++;
                count += curr;
            }
            else
                curr = 0;
        }
        return count;
    }
};