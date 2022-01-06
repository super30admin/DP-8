//Time: O(n^2)
//Space: O(1)
//leetcode: https://leetcode.com/submissions/detail/614315768/

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
        int count = 0;
        
        for(int i = 0; i < nums.length - 2; i++) {
            
            for(int j = i+2; j < nums.length; j++) {
                
                if(nums[i+1] - nums[i] == nums[j] - nums[j-1]) {
                    count ++;
                }
                else {
                    break;
                }
            }
        }
        return count;
    }
}