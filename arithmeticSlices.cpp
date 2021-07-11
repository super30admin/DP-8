// Time Complexity :O(n)
// Space Complexity : O(1) - Space optimized DP 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
/*class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        vector<int> dp(nums.size(),0);
        int count  = 0;
        for(int i = 2;i<nums.size();i++){
            int diff = nums[i-1] - nums[i-2];
            if(nums[i] - nums[i-1] == diff) dp[i] = 1 + dp[i-1];
            count += dp[i];
        }
        return count;
    }
};*/
class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        int count  = 0;
        int prev=0,curr;
        for(int i = 2;i<nums.size();i++){
            int diff = nums[i-1] - nums[i-2];
            if(nums[i] - nums[i-1] == diff){
                curr = 1+prev;
                count += curr;
                prev = curr;
            }
            else prev = 0;
        }
        return count;
        
    }
};