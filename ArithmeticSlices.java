// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yess
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach: 
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
            
        int prev=0;    
        int count=0;
        for(int i=2; i<n;i++){
            int curr=0;
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                curr=1+prev;
                count+=curr;
            }
            prev=curr;    
        }
        return count;
    }
}