using System;
using System.Collections.Generic;
using System.Text;

namespace DynamicProgramming
{
    public class ArithmeticSlices
    {
        /*
         * T.C: O(N) since we are traversing all the elements in the nums array
         * S.C: O(N) if use DP array otherwise O(1) if use the variable 
         */
        public int NumberOfArithmeticSlices(int[] nums)
        {
            if (nums == null || nums.Length < 3) return 0;

            int n = nums.Length;
            //int[] dp = new int[n];
            int count = 0;
            int prev = 0;

            /*
            for(int i = n-3; i >=0 ; i-- )
            {
                if(nums[i] - nums[i+1] == nums[i+1] - nums[i+2])
                {
                    dp[i] = dp[i+1] +1;
                    count += dp[i];
                }
            }*/

            for (int i = 2; i < n; i++)
            {
                if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2])
                {
                    //dp[i] = dp[i-1] +1;
                    //count += dp[i];
                    prev += 1;
                    count += prev;
                }
                else
                {
                    prev = 0;
                }
            }

            return count;
        }
    }
}
