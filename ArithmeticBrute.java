class Solution {
    //tc- o^2
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length < 3) return 0;
        int n = nums.length;
        int count =0;
        for(int i=0;i<n-2;i++)
        {
            int diff = nums[i+1] - nums[i];
            for(int j=i+2;j<n;j++)
            {
                if(nums[j]-nums[j-1] == diff) {count++;}
                else break;
            }

        }
 return count;
    }
   
}