//Time Complexity : O(n)
//Space Complexity : O(1)

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        
        int sum = 0;
        //int dp[] = new int[nums.length];
        
        int curr = 0;
        int prev = 0;
        
        for(int i=nums.length-3;i>=0;i--)
        {
            if(nums[i+2] - nums[i+1] == nums[i+1] - nums[i])
            {
                curr = prev + 1;
                sum += curr;
            }
            else
            {
                curr = 0;
            }
            
            prev = curr;
        }
        
        return sum;
    }
}