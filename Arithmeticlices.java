public class Arithmeticlices {
    //TC O(n) SC O(1)
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length<3) return 0;
        int n = nums.length;
        int count = 0;
        int prev = 0;

        for(int i = 2; i<n;i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                prev = 1+prev;
                count = count+prev;
            }
            else prev = 0;

        }
        return count;
    }
//TC O(n) SC O(n)
/*
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length<3) return 0;
        int n = nums.length;
        int count = 0;
        int[] dp = new int[n];

        for(int i = n-3; i>=0;i--){
            if(nums[i+2]-nums[i+1]==nums[i+1]-nums[i]){
                dp[i] = 1+dp[i+1];
                count = count+dp[i];
            }

        }
        return count;
    }

*/

    //Brute Force
    //TC O(n^2) SC O(1)

/*
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length<3) return 0;
        int n = nums.length;
        int count = 0;
        for(int i = 0; i<n-1;i++){
            int diff = nums[i+1]-nums[i];
            for(int j = i+1; j<n-1;j++){
                if(diff==nums[j+1]-nums[j]) count++;
                else break;
            }
        }
        return count;
    }*/
}
