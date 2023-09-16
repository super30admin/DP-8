// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class ArithmeticSlicesWithDPVariables {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        //int[] dp = new int[n];
        int result = 0;
        int curr = 0, prev = 0;
        for(int i=2; i<n; i++){
            if(nums[i] - nums[i-1] == nums[i-1]-nums[i-2]){
                curr = prev + 1;
                prev = curr;
                result += curr;
            }else{
                prev = 0;
            }
        }

        return result;
    }
}
