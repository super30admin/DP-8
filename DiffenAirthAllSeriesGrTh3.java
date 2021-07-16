/*Running Time Complexity: O(n)
Space complexity: Constant
Successfully Run and Compiled on leetcode
*/
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0;
        int prev = 0; int curr = 0;
        for(int i = 2;i<nums.length;i++){
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]){
                curr = prev+1;
                count += curr;
                prev = curr;
                }
            else{
                prev = 0;
            }
        }
                       
        return count;
    }
}