
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


// Approach : Sliding window
// Time Complexity : O(n)   n = nums.size()
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes

class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        int n = nums.size();
        int l = 0,r = 1;
        int count = 0;
        
        while(r<n-1)
        {
            int d = nums[r] - nums[l];
            while(r<n-1 && nums[r+1]-nums[r] == d)
            {
                int windowsize = (r+1)-l+1;
                count+= windowsize-3+1;
                r++;
            }
            l = r;
            r = l + 1;
        }
        return count;
    }
};

// Approach: DP 
// Time Complexity : O(n)   n = nums.size()
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes

class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        int n = nums.size();
        int count = 0;
        vector<int>dp(n,0);
        
        for(int i = 2;i<n;i++)
        {
            if(nums[i-2]-nums[i-1] == nums[i-1] - nums[i])
            {
                dp[i] = dp[i-1] + 1;
            }
            count+= dp[i];
        }
        return count;
    }
};

// Approach: dp with spacee optimized 
// Time Complexity : O(n)   n = nums.size()
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes

class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        int n = nums.size();
        int count = 0;
        int prev = 0;
        
        for(int i = 2;i<n;i++)
        {
            if(nums[i-2]-nums[i-1] == nums[i-1] - nums[i])
            {
                count+= prev + 1;
                prev++;
            }
            else prev = 0;
        }
        return count;
    }
};