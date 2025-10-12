

//Time Complexity: O(n)
//Space Complexity: O(n)

//submitted on leetcode

//We can use a dp array to store the number of arithmetic slices ending at each index. 
// If the current element and the previous two elements form an arithmetic sequence, 
// we can extend the number of slices ending at the previous index by 1. 
// Otherwise, we reset the count to 0. We accumulate the counts to get the total number of arithmetic slices.

//We can further optimize the space complexity to O(1) by using a single variable to keep track of the count of arithmetic slices ending at the previous index.

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length,c=0;
        int dp[]=new int[n];
        for(int i=2;i<n;i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2])
                dp[i]=dp[i-1]+1;
            else
                dp[i]=0;
            c+=dp[i];
        }
        return c;
    }
}