//TC : O(n)
//SC : O(1)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums==null || nums.length<3) return 0;

        int sum = 0;
        int count = 0;
        int n = nums.length;
        for(int i=2;i<n;i++)
        {
            int diff1 = nums[i] - nums[i-1];
            int diff2 = nums[i-1] - nums[i-2];
            if(diff1==diff2)
            {
                sum+=1;
                count+=sum;
            }
            else
                sum=0;
        }
        return count;
    }
}