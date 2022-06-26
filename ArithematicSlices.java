/*
 * TC = O(N)
 * SC = O(1)
 * 
 * Approach: We are traversing from the back. If the three elements at the back have the same difference, 
 * then we increase the prev and add it to the count.
 */

import java.util.*;

public class ArithematicSlices
{

    public static int numOfSlices(int[] nums)
    {
        if(nums == null || nums.length == 0) return 0;

        int n = nums.length;

        int count = 0,prev = 0;

        for(int i = n-3;i>=0;i--)
        {
            if(nums[i+2] - nums[i+1] == nums[i+1] - nums[i])
            {
                prev+=1;
                count+=prev;
            }
            else{
                prev = 0;
            }
        }

        return count;
    }

    public static void main(String args[])
    {
        int[] nums = {1,2,3,4};
        System.out.println(numOfSlices(nums));
    }
}