// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1) There are repeating sub array we are looking
// 2) So we can use DP
// 3) We traverse iteratively
//     a. Right to left doesn’t work and will give wrong answer
//     b. Start left to right from third element 
//     c. Create new array of count
//     d. Takes difference of i-2 - i-1 and i-1 - I, 
//         i. if they are same, add +1 to prev element count and set count for current
//         ii. If differennce is not same, set count to 0
//     e. In the end, add all count in result count array and return it


//TC: O(n)
//SC: O(1)
public int NumberOfArithmeticSlices(int[] nums) {
    if(nums == null || nums.Length == 0)
        return 0;
    
    int n = nums.Length;
    int count = 0;
    int prev = 0;
    
    //top to bottom
    for(int i = 2; i < n; i++)
    {
        if(nums[i-2] - nums[i-1] == nums[i-1] - nums[i])
        {
            prev = prev + 1;
            count = count + prev;
        }
        else
            prev = 0;
    }
    
    return count;
}

//TC: O(n)
//SC: O(n)
private int dpArithmetic(int[] nums)
{
        int n = nums.Length;
    int count = 0;
    int[] dp = new int[n];
    
        //bottom to top
    for(int i = n-3; i >= 0; i--)
    {
        if(nums[i+2] - nums[i+1] == nums[i+1] - nums[i])
            dp[i] = dp[i+1] + 1;
        count += dp[i];
    }
    
    count = 0;
    dp = new int[n];
    //top to bottom
    for(int i = 2; i < n; i++)
    {
        if(nums[i-2] - nums[i-1] == nums[i-1] - nums[i])
            dp[i] = dp[i-1] + 1;
        count += dp[i];
    }
    
    return count;
}


// 1) Brute force
// 2) Take arrays or 3 or more, check difference between tow element, if they are same, keep addign new element, 
//     a. If length is greater than 3, cpature it in result ate every index
//     b. Once difference is different, stop iteration
// 3) Start again same process above from 2nd element or index

//TC: O(n^2)
//SC: O(1)
private int bruteForceArithmeticSums(int[] nums)
{
    int n = nums.Length;
    int count = 0;
        //brute force
    for(int i = 0; i < n-1; i++)
    {
        //it gets difference of element at i and i+1
        int diff = nums[i+1] - nums[i];
        for(int j = i+1; j < n-1; j++)
        {
            //it gets difference of j(i+1) anf k+1(i+2)
            //then it compares the difference between
            //i+1 - i == i+2 - i
            if(nums[j+1] - nums[j] == diff)
                count++;
            else
                break;
        }
    }
    return count;
}