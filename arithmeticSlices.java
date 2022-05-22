//Brute force

//TC: O(n^2) whre n is the length of nums array
//SC: O(1)

//Code:
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        //null case
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int count =0;
        for(int i=0;i<n-2;i++){
            int diff = nums[i+1]-nums[i];
            for(int j=i+2;j<n;j++){
                if(nums[j]-nums[j-1] == diff){
                    count++;
                }else{
                    break;
                }
            }
        }
        return count;
    }
}

//Bottom-up dp
//TC: O(n) where n is the length of nums array
//SC: O(n)

//CODE
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        //null case
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int sum =0;
        int[] dp = new int[n];
        for(int i=n-3;i>=0;i--){
            if(nums[i+2]-nums[i+1] == nums[i+1] - nums[i]){
                dp[i]=dp[i+1]+1;
                sum+=dp[i];
            }
        }
        return sum;
    }
}

//Top-down dp
//TC: O(n) where n is the length of nums array
//SC: O(n)

//CODE
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        //null case
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int sum =0;
        int[] dp = new int[n];
        for(int i=2;i<n;i++){
            if(nums[i]-nums[i-1] == nums[i-1] - nums[i-2]){
                dp[i]=dp[i-1]+1;
                sum+=dp[i];
            }
        }
        return sum;
    }
}

//Two-pointer solution
//TC: O(n)
//SC:O(1)

//CODE
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        //null case
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int sum =0;
        int curr=0, prev =0;
        for(int i=2;i<n;i++){
            if(nums[i]-nums[i-1] == nums[i-1] - nums[i-2]){
                curr=prev+1;     //similar to dp[i] = dp[i-1]+1
                sum+=curr;
            }else{
                curr=0;    //if it is not a arithmentic slice set curr =0
            }
            prev =curr;
        }
        return sum;
    }
}