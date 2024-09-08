// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;

        int curr = 0;
        int  count = 0; 
 
        for(int i = n - 3; i >= 0; i--){
            if(nums[i + 2] - nums[i + 1] == nums[i + 1] - nums[i])
                curr = 1 + curr;
            else
                curr = 0;
            count += curr;
        }

        return count;
    }
}