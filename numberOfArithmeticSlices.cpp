// Approach 1: Brute force
// Time Complexity : O(n^2) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes 

// Approach 2/3: DP Bottom up / top down
// Time Complexity : O(n) 
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes

// Approach 4: DP spave optimised
// Time Complexity : O(n) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes  

/*
Approach 1: 2 loops, find every combination and check if they are a valid arithmetic slice
*/


class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        if(nums.size() < 3) return 0;
        int n = nums.size();
        int count = 0;

        // get difference between 0th and 1st numbers 
        // Keep increasing count for every valid arithmetic slice 
        for(int i = 1; i < n; i++) {
            int diff = nums[i] - nums[i-1];
            for(int j = i+1; j<n; j++) {
                if(nums[j]-nums[j-1] == diff)
                    count++;
                else
                    break;
            }
        }
        return count;
    }
};


// Approach 2: DP top down 

/*
Save the number of valid aritihmetic slice and if we find another one, add one to the result till that point 
Add all for result
3 5 7 9 11 12 16 18 20
_____
 ______
   _______
_______
  ________
__________     ________

3 5 7 9 11 12 16 18 20
0 0 1 2  3  0  0  0  1

*/

class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        if(nums.size() < 3) return 0;
        int n = nums.size();
        int count = 0;
        vector<int> dp(n, 0);

        for(int i = n-3; i>=0; i--) {
            if(nums[i]-nums[i+1] == nums[i+1]-nums[i+2]) {
                dp[i] = dp[i+1] + 1;
                count += dp[i];
            }
        }
        return count;
    }
};

// Approach 3: DP bottom up

class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        if(nums.size() < 3) return 0;
        int n = nums.size();
        int count = 0;
        vector<int> dp(n, 0);

        for(int i = 2; i<n; i++) {
            if(nums[i-2]-nums[i-1] == nums[i-1]-nums[i]) {
                dp[i] = dp[i-1] + 1;
                count += dp[i];
            }
        }
        return count;
    }
};

// Approach 4: DP space optimised 

class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        if(nums.size() < 3) return 0;
        int n = nums.size();
        int count = 0;
        int prev = 0;

        for(int i = 2; i<n; i++) {
            if(nums[i-2]-nums[i-1] == nums[i-1]-nums[i]) {
                prev += 1;
                count += prev;
            }
            else
                prev = 0;
        }
        return count;
    }
};

