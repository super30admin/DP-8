//TimeComplexity:O(n)
//SpaceComplexity:O(1)

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int prev = 0;
        int current=0;
        int count =0;
        for(int i = 2; i<nums.length;i++) {
         if(nums[i] - nums[i-1] == nums[i-1]-nums[i-2]) {
            current = prev+1;
            count = count+current;
         } else {
            current = 0;
         }
         prev = current;
        }

        return count;
    }
}