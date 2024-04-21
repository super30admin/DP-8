// TC= O(n)
// SC = O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(nums == null || n == 0) return 0;
        int cur =0; int prev = 0;
        int count =0;
        for(int i = 2; i<n; i++){
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                cur = 1+ prev;
                count += cur;
            }else{
                cur =0;
            }
            prev = cur;
        }
        return count;
    }
}