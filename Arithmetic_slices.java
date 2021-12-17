class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
        if(nums == null || nums.length == 0) return 0;
        
        int count = 0;
        
        int prev = 0;
        int curr = 0;
        
        for(int i = 2; i< nums.length; i++){
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                curr = prev + 1;
                count += curr;
                prev = curr;
            }else{
                prev = 0;
            }
            
        }
        return count;
        
    }
}
//TC: O(n)
//SC: O(1)
