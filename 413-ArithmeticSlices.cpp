/* 
    Time Complexity                              :  O(N)
    Space Complexity                             :  O(1) in spaceOptimized and O(N) in normal approach
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  


class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        // return spaceOptimized(nums);
        // return leftRightApproach(nums);
        return rightLeft(nums);
    }
    
    // left-right approach
    int leftRightApproach(vector<int>& nums) {
        int n = nums.size();
        int sum = 0;
        vector<int> dp(n,0);
        for(int i=2;i<n;i++) {
            if(nums[i-2] - nums[i-1] == nums[i-1] - nums[i]) {
                dp[i] = dp[i-1] + 1;
                sum += dp[i];
                
            }
        }
        return sum;
    }
    
    // left-right approach
    int spaceOptimized(vector<int>& nums) {
        int n = nums.size();
        int sum = 0;
        int prev = 0;
        for(int i=2;i<n;i++) {
            if(nums[i-2] - nums[i-1] == nums[i-1] - nums[i]) {
                prev += 1;
                sum += prev;
            } else {
                prev = 0;
            }
        }
        
        return sum;
    }
    
    // right left approach
    int rightLeftspaceOptimized(vector<int>& nums) {
        int n = nums.size(), sum = 0, prev = 0;
        for(int i=n-3;i>=0;i--) {
            if(nums[i+2] - nums[i+1] == nums[i+1] - nums[i]) {
                prev += 1;
                sum += prev;
            } else {
                prev = 0;
            }
        }
        
        return sum;
    }
};