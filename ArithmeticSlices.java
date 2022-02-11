// Time Complexity: O(n)
// Space Complexity: O(n)
// Variable
public class ArithmeticSlices
{
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length < 3)
            return 0;
        
        int count = 0, prev = 0;
        int n = nums.length;
        
        for(int i= 2 ; i < n; i++)
        {
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2])
            {
                    prev = prev + 1;
                    count = count + prev;
            }
            else
            {
                prev = 0;
            }
        }
        return count;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
// Top Up
public class ArithmeticSlices
{
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length < 3)
            return 0;
        
        int count = 0;
        int n = nums.length;
        int dp[] = new int[n];
        
        for(int i= 2 ; i < n; i++)
        {
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2])
            {
                    dp[i] = dp[i-1] + 1;
                    count = count + dp[i];
            }
        }

        return count;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(n)
// Bottom Up
public class ArithmeticSlices
{
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length < 3)
            return 0;
        
        int count = 0;
        int n = nums.length;
        int dp[] = new int[n];
        
        for(int i= n-3 ; i >=0; i--)
        {
            if(nums[i+1] - nums[i] == nums[i+2] - nums[i+1])
            {
                    dp[i] = dp[i+1] + 1;
                    count = count + dp[i];
            }
        }

        return count;
    }
}
// Time Complexity: O(n^2)
// Space Complexity: O(1)
// Brute Force
public class ArithmeticSlices
{
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length < 3)
            return 0;
        
        int count = 0;
        
        for(int i= 0 ; i < nums.length -1 ; i++)
        {
            int diff = nums[i + 1] - nums[i];
            
            for(int j = i+1 ; j < nums.length -1 ; j++)
            {
                if(nums[j+1] - nums[j] == diff)
                {
                    count++;
                }
                else
                {
                    break;
                }
            }
        }
        return count;
    }
}