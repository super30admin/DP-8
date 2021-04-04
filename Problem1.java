//time complexity-O(n)
//Space complexity-O(1)
//Ran on leetcode-Yes
//Solution with comments-
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3)
            return 0;
        int prev=0;
        int sum=0;
        for(int i=nums.length-3;i>=0;i--){//maintaing the count of valid slices based on previous count
            if((nums[i+2]-nums[i+1])==nums[i+1]-nums[i]){
                prev=prev+1;
                sum+=prev;
            }
            else
                prev=0;
        }
        return sum;
    }
}