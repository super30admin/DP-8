//Time complexity: O(n)
//Space complexity: O(1)

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
        if(n<3)
            return 0;
        int sum=0;
        int prev=0;int curr=0;
        for(int i=2;i<n;i++)
        {
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2])
                curr=prev+1;
            else
                curr=0;
            sum+=curr;
            prev=curr;
        }
        return sum;
    }
}