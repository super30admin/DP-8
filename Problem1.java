
// time - O(n^2)
// space - O(1)

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {

        if(nums == null || nums.length < 3) return 0;

        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n - 2; i++) {
            int diff = nums[i+1] - nums[i];
            for(int j = i+1; j < n - 1; j++){
                if(nums[j+1] - nums[j] == diff) {
                    count++;
                }
                else {
                    break;
                }
            }
        }
        return count;
    }
}



// time - O(n)
// space - O(n)


class Solution {
    public int numberOfArithmeticSlices(int[] nums) {

        if(nums == null || nums.length < 3) return 0;

        int n = nums.length;
        int [] dp = new int[n];
        int sum = 0;
        for(int i = 2; i < n; i++){
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                dp[i] = dp[i-1] + 1;
                sum+= dp[i];
            }
        }

        return sum;
    }
}

// time - O(n)
// space - O(1)

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {

        if(nums == null || nums.length < 3) return 0;

        int n = nums.length;
        int [] dp = new int[n];
        int sum = 0;
        int curr = 0; int prev = 0;
        for(int i = 2; i < n; i++){
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                curr = prev + 1;
                sum += curr;
                prev = curr;
            }
            else {
                prev = 0;
            }
        }

        return sum;
    }
}