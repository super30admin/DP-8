// Time: O(N) | Space: O(N)

//optimal but not space efficent
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int[] dp = new int[nums.length];
        int count = 0;
        for(int i=2;i<nums.length;i++) {
            // we keep comparing every continous three consequtive values and make pairs
            if(nums[i-1] - nums[i-2] == nums[i]-nums[i-1]) {
                dp[i] = dp[i-1]+1;
                count += dp[i];
            }
        }
        return count;
    }
}

//Time: O(N) | Space: O(1)

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0;
        int prev = 0;
        int curr=0;
        for(int i=2;i<nums.length;i++) {
            curr = 0;
            if(nums[i-1] - nums[i-2] == nums[i]-nums[i-1]) {
                curr = prev+1;
                count += curr;
            }
            prev =curr;
        }
        return count;
    }
}