//Time : O(n)
//Space : O(1)
//LeetCode : Yes

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
    if(nums.length < 3 )    return 0;
    int count = 0;
    int help ;
    int prev = 0 ;
    int l = 0;
    int h = 1;
    while(l<nums.length-1 && h<nums.length){
        help = 0;
        if(h-l>=2){
            if(nums[h]-nums[h-1] == prev){
                while(h<nums.length && nums[h]-nums[h-1] == prev){
                    help++;
                    count += help;
                    h++;
                }
            }
            l = h-1;
           if(h<nums.length) prev = nums[h]-nums[l];
        }
        else{
            if(h<nums.length)   prev = nums[h]-nums[l];
            h++;
        }
    }
    return count;
    }
}
