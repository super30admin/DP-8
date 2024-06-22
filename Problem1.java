package DP-8;
// TC: O(n)
// SC: O(1)
public class Problem1 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int count=0;
        int prev=0;
        int curr=0;
        for(int i=2;i<n;i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                curr=prev+1;
                prev=curr;
                count+=curr;
            }else{
                prev=0;
            }
        } 
    return count;
    }
}
