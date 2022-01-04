//O(N) time
//O(1) space

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3)
            return 0;

        int prev = 0;
        int total = 0;
        for(int i=2;i<nums.length;i++){
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2])
                prev = prev + 1;

            else
                prev = 0;
            total+=prev;
        }
        return total;
    }
}