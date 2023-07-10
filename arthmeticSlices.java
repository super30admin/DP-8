//  tc : O(n)
//  sc : O(1)

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int res = 0, prev =0;
        for(int i = 2 ; i< nums.length ; i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]) res+=++prev;
            else prev =0 ;
        }
        return res;
    }
}
