// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class ArithmeticSlicesBruteForce{

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int result = 0;
        for(int i=0; i<n-2; i++){
            int diff = nums[i+1] - nums[i];
            for(int j= i+2; j<n; j++){
                if(nums[j] - nums[j-1] == diff) result++;
                else break;
            }
        }
        return result;
    }
}
