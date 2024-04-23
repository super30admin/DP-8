package week12.day6;
//TC - O(n)
//SC - O(n)
//https://leetcode.com/problems/arithmetic-slices/
public class ArithmeticSlices {
	public int numberOfArithmeticSlices(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || i == 1) {
            	dp[i] = 0;
            	continue;
            }
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2])
                dp[i] = dp[i - 1] + 1;
        }
        int result =0;
        for (int i = 0; i < nums.length; i++) {
        	result = result+dp[i];
        }
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArithmeticSlices a = new ArithmeticSlices();
		int[] nums = {1,2,3,4};
		System.out.println(a.numberOfArithmeticSlices(nums));
	}

}
