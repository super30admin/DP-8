//TC: O*(n), SC: O(1)

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int result = 0, n = nums.length;
        int curr = 0;
        for(int i = 2; i < n; i++){
            if(nums[i] - nums[i-1]  != nums[i-1]-nums[i-2]){
                curr = 0;
            }else{
                curr = curr + 1;
                result += curr;
            }
        }
        return result;
    }
}