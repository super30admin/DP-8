// Time Complexity: O(n^2)
// Space Complexity: O(1)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3) return 0;
        int res=0;
        for(int i=2;i<nums.length;i++){
            int p1=0; int p2=i;
            while(p2<nums.length){
                if(checkForA(nums,p1,p2)) res++;
                p1++;
                p2++;
            }
        }
        return res;
    }
    
    private boolean checkForA(int[] nums, int p1, int p2){
        int diff = nums[p1+1] - nums[p1];
        while(p1<p2){
            if((nums[p1+1] - nums[p1]) != diff) return false;
            p1++;
        }
        return true;
    }
}
