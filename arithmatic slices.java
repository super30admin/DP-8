//Timecomplexity:- O(n);
//Spaecomplexity:- O(1).




class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int i=nums.length-3;
        int prev=0;
        int sum=0;
        while(i>=0){
            if(isArithmetic(nums[i],nums[i+1],nums[i+2])){
               prev=1+prev;
               sum=sum+prev;
            }
            else{
                prev=0;
            }
            i--;            //Starting from nums.length-3,if last three are valid adding one to prev value.
            // and sum would be adding previous subsets+present subsets which is total sum.
            //if not valid prev will be no altered.
            
        }
        return sum;
    }
    private boolean isArithmetic(int x,int y, int z){
        if((y-x)==(z-y)){
            return true;
        }
        return false;
    }
}