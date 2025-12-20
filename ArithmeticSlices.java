// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : We can maintain a dp array and maintain the count of arithmetic slices possible but we can do better by avoiding the space of dp array as well.
// We start looping the nums array by sliding window tchnique and at each index we check if a 3 element length of arithmetic slice is formed or yet. If yes we
// increment curr and add to result, else we make curr as 0. As we are incrementing the curr at each arithmetic slice check, it covers the calculations of
// the permutations possible within as well.

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int res = 0;
        int curr = 0; //count of arithemtic slices possible at i.
        for(int i = 0;i < n-2;i++){
            if(nums[i+1] - nums[i] == nums[i+2] - nums[i+1]){ //check if arithmetic slice is formed with 3 elements
                curr++; //count of arithemtic slices possible at i.
                res += curr; //add to result.
            } else{
                curr = 0; //reset curr
            }
        }
        return res;
    }
}