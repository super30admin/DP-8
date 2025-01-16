public class Arithmetic{
    //o(n) o(1)
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n < 3) return 0;
        int dp[] = new int[n];
        int count = 0, prev = 0, curr = 0;
        for(int i = 2; i < n; i++){
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                //  dp[i] = dp[i-1]+1;
                curr = prev + 1;
            }else{
                curr = 0;
            }
            // count += dp[i];
            count += curr;
            prev = curr;
        }
        return count;
    }

    //o(n^2)
    // public int numberOfArithmeticSlices(int[] nums) {
    //     int n = nums.length;
    //     int count = 0;
    //     for(int i = 0; i < n; i++){
    //         for(int j = i+2; j < n; j++){
    //             if(nums[j] - nums[j-1] == nums[j-1] - nums[j-2]){
    //                 count++;
    //             }else{
    //                 break;
    //             }
    //         }
    //     }

    //     return count;
    // }
}