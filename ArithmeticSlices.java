/*
* Approach1: BruteForce
    - Use nested iterations
    - calculate the intial diff, and keep on exploring j until the diff remains the same and keep incrementing result
    - break when the diff changes
    - TC: O(n ^2) -> nested iterations
    - SC: O(1)-> no additional space used
 */
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int res = 0;
        // upto last third index because there has to be at least three elements for a sequence to be called as arithmetic
        for(int i = 0; i < nums.length - 2; i++){
            int diff = nums[i + 1] - nums[i];
            for(int j = i + 2; j < nums.length; j++){
                if(nums[j] - nums[j - 1] == diff)
                    res += 1;
                else
                    break;
            }
        }
        return res;
    }
}

/*
* Approach2: DP -> tabulation (botton up)
- Idea is to start from the 3rd index and check the diff between 3rd and 2nd and 2nd and 1st 
    - if it is the same, update the dp array with previously calculated slices + 1 and update result as well
- TC: O(n) -> iterate over nums array
- SC: O(n) -> dp array
 */
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int dp[] = new int[nums.length];
        int res = 0;

        for(int i = 2; i < nums.length; i++){
            if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]){
                dp[i] = dp[i-1] + 1;
                res += dp[i];
            }
        }
        return res;
    }
}

/*
* Approach3: DP -> tabulation (botton up)
- Similar to approach 2 but using a curr pointer to keep track of the current partition score, reset if the diff is not equal so no need to maintain dp array
- TC: O(n) -> iterate over nums array
- SC: O(1) -> no extra space useed
 */
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int res = 0;
        int curr = 0;

        for(int i = 2; i < nums.length; i++){
            if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]){
                curr += 1;
                res += curr;
            }
            else{
                curr = 0;
            }
        }
        return res;
    }
}