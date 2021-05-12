class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length <= 2){
            return 0;
        }
        int prev = 0;
        int sum = 0;
        
        for(int i = nums.length - 3; i >= 0; i--){
            //validity check and updating prev and sum
            if(nums[i+2] - nums[i+1] == nums[i+1] - nums[i]){
                prev += 1;
                sum += prev;
            }else{
                prev = 0;
            }
        }
        
        return sum;
    }
}
//Time Complexity: O(n)
//Space Complexity: O(1)