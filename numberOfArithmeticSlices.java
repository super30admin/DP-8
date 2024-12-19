class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int start=0,end=0,diff=0,count=0;
        for(end=1;end<n;end++){
            if(diff!=nums[end]-nums[end-1]){
                if(end-start>2){
                    count+=((end-start-2)*(end-start-1))/2;
                }
                diff=nums[end]-nums[end-1];
                start=end-1;
            }

        }
        if(n>2){
            if(end-start>2)
            count+=((end-start-2)*(end-start-1))/2;
        }
        return count;
    }
}
