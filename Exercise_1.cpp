// Time Complexity : O(n) where n is the number of elements in the array
 // Space Complexity : O(1) is constant as we are using only constant space.
 // Were you able to solve it on Leetcode : Yes
 // Any problem you faced while coding this : No

class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {

        if(nums.empty()) {
            return 0;
        }

        int n = nums.size();
        int count = 0;
        // vector<int> dp(n, 0); // DP based approac O(n)
        
        int curr = 0; // Optimized DP approach with O(1) init for storing curr element
        
        // start from the 3rd element and check if the diff b/w 3rd and 2nd element is same as 2nd and 1st
        // i.e. the three elements form an arithmetic slice
        for (int i = 2; i<n; i++) {
            // assign curr as prev element
            int prev=curr;
            // check for validity of arithmetic slice, if it is equal then curr element is prev + 1
            // else reset curr to zero, in this way we only count arithmetic slices that end at that particular index
            // and mulitple slices can exist using that particular index
            if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2] ){
                curr = prev + 1;
            }
            else{
                curr = 0;
            }
            // increment count by curr everytime
            count += curr;

        }
        
        return count;
    }
};