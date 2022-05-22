//Time Complexity O(N)
//Space Complexity O(1)
//Leetcode tested

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        int dp=0;
        int res=0;

        for (int i = 2; i < nums.length; i++) {
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]){
                dp = 1+ dp;
                res+=dp;
            }else dp=0;
        }
        return res;
    }
}
