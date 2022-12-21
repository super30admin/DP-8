// Time Complexity : O(n^2)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/*
 * Brute Force Approach 
 */

public class Arithmetic {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n-1;i++)
        {
            int diff = nums[i+1] - nums[i];
            for(int j = i+1;j<n-1;j++)
            {
                if(nums[j+1] - nums[j] == diff)
                    count++;
                else
                    break;
            }
        }
        return count;
    }
}

/*
 * Approach 2 - Using DP
 * 1 - We can start from with either left or right side.
 * 2 - Here, the repeated sub-problem observed in Brute Force is that, for every i, we are checking the difference repeatedly.
 * As i increments, some differences are getting calculated repeatedly.
 * Time Complexity - O(n)
 * Space Complexity - O(n) - can be reduced to O(1)
 */
public int numberOfArithmeticSlices(int[] nums) {
    if(nums.length == 0 || nums == null)
        return 0;
    
    int n = nums.length;
    int count = 0;
    int[] dp = new int[n];
    
    for(int i = 2; i<n; i++)
    {
        if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2])
        {
            dp[i] = dp[i-1] + 1;
            count += dp[i];
        }
    }
    return count;
}