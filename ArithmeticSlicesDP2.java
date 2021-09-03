// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3)
            return 0;
        int sum = 0;
        int prev = 0;
        int curr = 0;
         for(int i = 2; i < nums.length; i++){
            if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]){
                curr = prev + 1;
                sum += curr;
                prev = curr;
            }
             else
                prev = 0;
        }
        return sum;
    }
}