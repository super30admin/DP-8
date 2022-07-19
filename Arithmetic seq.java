TC:O(n)
SC:O(1)
Leetcode: successfully run
Stored the sequence length so far in the prev variable and add that to the count at every index

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0,prev=0;
        if(nums.length < 3) return 0;
        int diff = nums[1] - nums[0];
        for(int i=2;i<nums.length;i++){
            if(nums[i]-nums[i-1] == diff){
                prev = prev + 1;
                count = count + prev;
            } 
            else {
                prev=0;
                diff = nums[i]-nums[i-1];
            }
        }
        return count;
    }
}