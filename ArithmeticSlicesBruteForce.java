// Time Complexity : O(n ^ 2)
// Space Complexity : O(1)

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3)
            return 0;
        int count = 0;
        for(int i = 0; i < nums.length - 2; i++){
            int diff = nums[i + 1] - nums[i];
            for(int j = i + 1; j < nums.length - 1; j++){
                if(nums[j + 1] - nums[j] == diff)
                    count++;
                else
                    break;
            }
        }
        return count;
    }
}