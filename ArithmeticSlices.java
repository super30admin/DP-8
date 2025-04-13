//The approach here is to use DP to store the number of slices at an index and use it for computer other slices
//To achieve this, if we find a slice at an index, we store that count at the same index in dp array
//When traversing, if the current difference is same as that of to the difference to the right, then we take the count of the slices and add 1 to it and add to the result count and store it at that index in dp array
//Time Complexity: O(n)
//Space Complexity: O(n) for dp array
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        // null check
        if (nums == null || nums.length < 3) return 0;        
        int n = nums.length;
        int cnt = 0;
        int [] dp = new int[n];

        for(int i = n-3; i>=0; i--){
            if(nums[i+2] - nums[i+1] == nums[i+1] - nums[i]){
                dp[i] = dp[i+1] + 1;
            } else {
                dp[i] = 0;
            }
            cnt +=dp[i];
        }
        
        return cnt;
    }
}