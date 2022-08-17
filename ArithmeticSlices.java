class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
     int count =0;
        for( int i =0;i<nums.length-2;i++)
        {  
            int j= i+1;
            int diff=nums[j]-nums[i];
            j++;
            while(j<nums.length && nums[j]-nums[j-1]==diff)
            {
                count++;
                j++;
            }
          
        }
        return count;
    }
}