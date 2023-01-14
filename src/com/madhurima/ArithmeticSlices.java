//TC = O(n*n) for brute force, O(n) for DP, O(n) for space optimized DP
//SC = O(1) for brute force, O(n) for DP, O(1) for space optimized DP
// Was able to run in LeetCode = yes

package com.madhurima;

public class ArithmeticSlices {
}


class ArithmeticSlicesBruteForce {

    //brute force
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length < 3){
            return 0;
        }

        int n = nums.length;
        int count = 0;

        for(int i = 0; i < n-1; i++){
            int diff = nums[i+1] - nums[i];
            for(int j = i+1; j < n-1; j++){
                if(nums[j+1] - nums[j] == diff){
                    count++;
                }else{
                    break;
                }
            }
        }

        return count;

    }
}

class ArithmeticSlicesDP {

    //dp
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length < 3){
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        int count = 0;

        for(int i = n-3; i >= 0; i--){
            if(nums[i+2] - nums[i+1] == nums[i+1] - nums[i]){
                dp[i] = dp[i+1] + 1;
                count = count + dp[i];
            }
        }

        return count;

    }
}

class ArithmeticSlicesDPOptimized {

    //dp , optimizing space
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length < 3){
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        int count = 0;
        int prev = 0;

        for(int i = 2; i < n; i++){
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                prev = prev+1; //found arithmetic subarray
                count = count + prev;
            }else{
                prev = 0;
            }
        }

        return count;

    }
}