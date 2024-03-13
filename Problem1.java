class Solution {
    //TC: O(n)
    //SC:  o(1)
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums  == null || nums.length == 0) return 0;
        int n = nums.length;
        int count = 0;
        int prev = 0;
       
        for(int i = 2; i < n;i++){
            int curr = 0;
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                curr = 1+prev;
                count += curr;
            }
            prev = curr;
        }
        return count;
    }
}
