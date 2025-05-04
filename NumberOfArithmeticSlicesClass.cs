public class Solution {
    // TC => O(n)
    // SC => O(n)
    public int NumberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.Length < 3){
            return 0;
        }

        int n = nums.Length;
        int count = 0;
        int[] counts = new int[n];

        for(int i = n-3; i >= 0; i--){
            if(nums[i+2] - nums[i+1] == nums[i+1] - nums[i]){
                counts[i] = counts[i+1]+1;
            }
            count += counts[i];
        }

        return count; 
    }

    // TC => O(n^2)
    // SC => O(1)
    // public int NumberOfArithmeticSlices(int[] nums) {
    //     if(nums == null || nums.Length < 3){
    //         return 0;
    //     }

    //     int n = nums.Length;
    //     int count = 0;
    //     for(int i = 0; i< n-2;i++){
    //         int diff = nums[i+1] - nums[i];
    //         for(int j = i+1; j < n-1; j++){
    //             if(nums[j+1] - nums[j] != diff){
    //                 break;
    //             }
    //             count++;
    //         }
    //     }
    //     return count;
    // }
}