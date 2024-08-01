class Solution {
    //Space optimized DP
    //Time complexity: O(n)
    //Space complexity: O(1)
    //Did this run on Leetcode: yes
    public int numberOfArithmeticSlicesSpaceOptimizedDP(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        int n = nums.length;
        int[] dp = new int[n];
        int current = 0;
        int prev = 0;
        for (int i = n - 3; i >= 0; i--) {
            if (nums[i + 2] - nums[i + 1] == nums[i + 1] - nums[i]) {
                //dp[i] = dp[i+1] + 1;
                //count += dp[i];
                current = prev + 1;
                count += current;
            } else {
                current = 0;
            }
            prev = current;
        }
        return count;
    }


    //DP
    //Time complexity: O(n)
    //Space complexity: O(n)
    //Did this run on Leetcode: yes
    public int numberOfArithmeticSlicesDP(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int count = 0;
        int n = nums.length;
        int[] dp = new int[n];
        for(int i = n-3; i >= 0; i--){
            if(nums[i+2] - nums[i+1] == nums[i+1] - nums[i]) {
                dp[i] = dp[i+1] + 1;
                count += dp[i];
            }
        }
        return count;
    }


    //Sliding Window O(n) solution
    //Time complexity: O(n)
    //Space complexity: O(1)
    //Did this run on Leetcode: yes
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int count = 0;
        int minWindowSize = 3;
        int start = 0;
        int end = start;
        int diff = 5000;

        while(start < nums.length && end < nums.length){
            int currentWindowSize = end - start + 1;
            if(currentWindowSize < 2){
                end++;
                if(end < nums.length){
                    diff = nums[end] - nums[start];
                }
            }else{
                if(end + 1 < nums.length && nums[end + 1] - nums[end] == diff){
                    count++;
                    end++;
                }else{
                    start++;
                    int currentWindowLength = end - start + 1;
                    if(currentWindowLength >= 3){
                        //count the subrrays while shrinking the window
                        int n = currentWindowLength - 3 + 1;
                        if(n == 0){
                            count += 1;
                        }else{
                            count += (n * (n + 1)) /2 ;
                        }
                    }
                    start = end;
                }
            }
        }
        return count;
    }

}