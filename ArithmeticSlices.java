//Time Complexity: o(n)
//Space Complexity: o(n)
//Expln: Maintain a dp array by storing the num of max possible slices possible until then by comparing last 2 diff btw 3 elements
// if same increment the last indexes dp array result by 1 and store it under current element.
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if(len < 3) return 0;
        int[] dp = new int[len];
        int count = 0;
        for(int i = 2; i < len; i++)
        {
            if(nums[i] - nums[i-1] == nums[i-1]-nums[i-2])
            {
                dp[i] = dp[i-1]+1;
                count += dp[i];
            }
        }
        return count;
    }
}