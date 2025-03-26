// dp time:O(n), space:O(1)
class arithmetic_slice {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length <3){
            return 0;
        }
        int n = nums.length;
        int prev =0;
        int count=0;

        for(int i= 2; i<n; i++){
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                prev = 1+ prev;
            }else{
                prev =0;
            }
            count = count+prev;
        }
        return count;
    }
}

