//TC = O(n)
//SC = O(1)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int prev = 0;
        int count = 0;
        for(int i = nums.length -3; i >=0; i--)
        {
            int curr = 0;
            if(nums[i+1] - nums[i] == nums[i+2] - nums[i+1])
            {
                curr = prev + 1;
                count+=curr;
            }
            prev = curr;
        }
        return count;
    }
}
