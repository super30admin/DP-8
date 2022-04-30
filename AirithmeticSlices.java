// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// The idea is to be considered as AP the dif of prev and cur and prev and prevof prev
// Should be the same. Hence we will loop through the nums and store the values at the index
// in a prev variable and we can reuse it in case our progression continues.
// We will also keep adding the count to the answer variable and finally return it.
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0, prev = 0; 
        for(int i = 2; i < nums.length; i++){
            int dif1 = nums[i] - nums[i-1];
            int dif2 = nums[i-1] - nums[i-2];
            if(dif1 == dif2){
                int cur = prev + 1;
                ans += cur;
                prev = cur;
            }
            else{
                prev = 0;
            }
        }
        return ans;
    }
}