// TC: O(n)
// SC: O(1)

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums==null || nums.length<3) return 0;
        int n= nums.length;
        
        int count =0;
        int prev =0;
        
        for(int i=2;i<n;i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                int curr=prev+1;
                prev = curr;
                count += curr;
            }else{
                prev = 0;
            }
            
        }
        
        return count;
    }
}
