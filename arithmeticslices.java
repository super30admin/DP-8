// Time Complexity: O(n) – single pass over the array.
// Space Complexity: O(1) – constant extra space for curr and count.

//Scan from i = 2 to n-1; if nums[i]-nums[i-1] == nums[i-1]-nums[i-2], increment curr, else reset curr to 0.
//curr equals the number of arithmetic subarrays ending at index i; accumulate into count each step.
//Return count at the end.

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int count = 0; 
        int curr = 0;

        for(int i = 2; i < n; i++) {
            if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                curr = curr + 1;
            } else {
                curr = 0;
            }
            count += curr;
        }

        return count;
    }
}
