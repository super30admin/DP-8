// TC: O(n)
// SC: O(1)

// 1: We maintain variables in the place of a DP array to iterate through the nums array and make two comparisons at a time
// 2: If the difference between two continuous indices are the same, we increment the current pointer and add to the running total
// 3: If we encounter a change in the difference, we reset our current pointer
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int count = 0;
        int curr=0, prev=0;

        for(int i = 2; i<n; i++){
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                curr = 1+prev;
                count += curr;
            }
            else{
                curr = 0;
            }
            prev = curr;
        }
        return count;
    }
}