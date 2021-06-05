//Dp approach without space
//Time Complexity: O(n)
//Space Complexity: O(1)
// Did this code successfully run on Leetcode :yes
// Your code here along with comments explaining your approach
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        //use a a variable to keep track of previous subarrays with same difference
        int prev = 0;
        int count=0;
        //i=2 since the length of the subarrya must be atleast 2
        for(int i=2;i<nums.length;i++){
            //check is the difference is same
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]){
                //record the subarray so far
                prev = 1 + prev;
                //count of subarrays
                count = count+prev;
            }
            else{
                //if the difference doesn't match anymore, visit the next subarray with same difference. In order to not carry the previous subarry difference into the next one, change prev = 0
                prev = 0;
            }
        }
        return count;
    }
}

//Dp approach with extra space
//Time Complexity: O(n)
//Space Complexity: O(n)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        //use a dp array to keep track of previous subarrays with same difference
        int[] dp = new int[nums.length];
        int count=0;
        //i=2 since the length of the subarrya must be atleast 2
        for(int i=2;i<nums.length;i++){
            //check is the difference is same
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]){
                //record the subarray so far
                dp[i] = 1 + dp[i-1];
                //count of sunarrays
                count = count+dp[i];
            }
        }
        return count;
    }
}
//Brute force
//Time complexity : O(n^2)
//Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Your code here along with comments explaining your approach
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int count = 0;
        for(int i=0;i<nums.length-2;i++){
            //check the difference between the current element and the next element
            int diff = nums[i+1] - nums[i];
            for(int j=i+1;j<nums.length-1;j++){
                //check the difference from the i+1th element to see if the same difference is occurening
                if(diff==nums[j+1] - nums[j]){
                    //if matching then increment the count of the current subarray
                    count++;
                }
                else{
                    //the pattern of the same difference has stopped and we have to look for the next new difference
                    break;
                }
            }
        }
        return count;
    }
}