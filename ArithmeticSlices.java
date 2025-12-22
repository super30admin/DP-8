// 413. Arithmetic Slices
// https://leetcode.com/problems/arithmetic-slices/description/

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */


class Solution {
    public int numberOfArithmeticSlices(int[] nums) {

        int result = 0;
        if(nums.length < 3){
            return result;
        }
        int[] resultArr = new int[nums.length];

        for(int i = 2 ; i < nums.length ; i++){
            int diff1 = nums[i] - nums[i - 1];
            int diff2 = nums[i - 1] - nums[i - 2];
            if(diff1 == diff2){
                resultArr[i] = resultArr[i - 1] + 1;
                result = result + resultArr[i];
            }
        }
        
        return result;
    }
}