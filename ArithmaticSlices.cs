// time complexity - O(n)
// space complexity - O(n)
public class Solution
{
    public int NumberOfArithmeticSlices(int[] nums)
    {
        int n = nums.Length;
        if (n < 3)
        {
            return 0;
        }
        int res = 0;
        // dynamic programming O(n)
        int[] dp = new int[n];
        Array.Fill(dp, 0);
        int diff = nums[1] - nums[0];
        for (int j = 2; j < n; j++)
        {
            if (nums[j] - nums[j - 1] == diff)
            {
                dp[j] = dp[j - 1] + 1;
                res = res + dp[j];
            }
            else
            {
                diff = nums[j] - nums[j - 1];
            }
        }
        return res;
        // Brute force n^2 time complexity
        // for(int i=0;i<=n-3;i++)
        // {
        //     for(int j=i+2;j<n;j++)
        //     {
        //         if(nums[j]-nums[j-1] == nums[j-1]-nums[j-2])
        //         {
        //             res++;
        //         }
        //         else
        //         { break;}

        //     }
        // }
        // return res;
    }
}