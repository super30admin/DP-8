//TC : O(n)
//SC : O(1)
//Bottom-Up DP Solution without using extra space

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        
        //int[] dp = new int[nums.length];
        int result = 0;
        
        int lastCurr = 0, curr = 0;
        for(int i = nums.length - 3; i >= 0; i--){
            if(nums[i+1] - nums[i] == nums[i+2] - nums[i+1]){
                curr = lastCurr + 1;
                result += curr;
                //dp[i] = dp[i+1] + 1;
                //result += dp[i];
            }else{
                curr = 0;
            }
            
            lastCurr = curr;
        }
        
        return result;
    }
}

/*
//TC : O(n) // Iterating for single pass
//SC : O(n) // maintaining 1D array 
//Bottom-Up DP Solution

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        
        int[] dp = new int[nums.length];
        int result = 0;
        for(int i = nums.length - 3; i >= 0; i--){
            if(nums[i+1] - nums[i] == nums[i+2] - nums[i+1]){
                dp[i] = dp[i+1] + 1;
                result += dp[i];
            }
        }
        
        return result;
    }
}



*/

/*
//TC : O(n) // Iterating for single pass
//SC : O(n) // maintaining 1D array 
//Top-Down DP Solution

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        
        int[] dp = new int[nums.length];
        int result = 0;
        for(int i = 2; i< nums.length; i++){
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                dp[i] = dp[i-1] + 1;
                result += dp[i];
            }
        }
        
        return result;
    }
}
*/


/*

//TC : O(n^2)
//SC : O(1)
//Brute-Force Solution
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        
        int counter = 0;
        
        for(int i = 0; i< nums.length - 2; i++){
            int d = nums[i+1] - nums[i];
            for(int j = i+2; j< nums.length; j++){
                if(nums[j] - nums[j-1] == d){
                    counter++;
                } else{
                    break;
                }
            }
        }
        
        return counter;
        
    }
}

*/