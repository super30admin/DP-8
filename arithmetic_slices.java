// Time Complexity : O(n)
// Space Complexity :O(1)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        
        int prev=0;
        int count=0;
        int n=nums.length;
        for(int i=2;i<n;i++){
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]){
                prev++;
                count+=prev;
            }else{
                prev=0;
            }
        }
        return count;
    }
}