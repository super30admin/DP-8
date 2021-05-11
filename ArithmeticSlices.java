class ArithmeticSlices {
    
    // Time Complexity: O(n)    (where n -> length of nums array)
    // Space Complexity: O(1)
    
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length <= 2)
            return 0;
        int n = nums.length;
        int prev = 0;
        int sum = 0;
        
        for(int i = n - 3; i >= 0; i--){
            if(nums[i+2] - nums[i+1] == nums[i+1] - nums[i]){
                prev = 1 + prev;
                sum += prev;
            }else{
                prev = 0;
            }
        }
        return sum;
    }
}