Time: O(n)
Space: O(1)
Leetcode: https://leetcode.com/submissions/detail/614352640/
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
        int count = 0;
        int result = 0;
        for(int i = 2; i < nums.length; i++) {
            
           //Check triplet and also the new element difference is same as previous difference 
           if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
               count ++;
               result += count;
               
           } else {
               
               count = 0;
           }
        }
        return result;
    }
}