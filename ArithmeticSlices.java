public class ArithmeticSlices {
    //Time complexity: O(N)
    //Space Complexity: O(N)
    public int numberOfArithmeticSlices(int[] nums) {

        int[] dp = new int[nums.length];
        int sum = 0;
        for(int i = 2; i< nums.length; i++){
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                dp[i] = dp[i-1] +1;
            }
            sum+= dp[i];
        }

        return sum;

    }

}
