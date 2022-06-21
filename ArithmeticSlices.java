//Brute Force
class Solution {

    //Time Complexity : 0(n^2) where n is the length of nums array
    //Space Complexity: 0(1)
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while coding: No

    //In brief Explain your approach

    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length < 3){    //if nums length is less than 3, than I cannot slice the array hence returning 0
            return 0;
        }
        int count = 0;  //to count the no. of slices or subarrays
        int n = nums.length;
        for(int i = 0; i < n-1; i++){   //starts from 0 and goes upto length -1
            int diff = nums[i+1] - nums[i]; //calculating the difference between next element and current
            for(int j = i+1; j < n-1; j++){ //starts from i+1 as need to iterate over every element from i+1 to length to check ow many slices can be for current combination of the difference
                if(nums[j+1] - nums[j] == diff){    //comparing the next difference with the previous, if same than it is a slice
                    count++;
                }
                else{
                    break;  //if it is not, then move over to the next possible subarray of different difference and a difference slicing
                }
            }
        }
        return count;   //returning count at the end
    }
}

//DP from left to right
class Solution {

    //Time Complexity : 0(n) where n is the length of nums array
    //Space Complexity: 0(n)
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while coding: No

    //In brief Explain your approach

    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length < 3){
            return 0;
        }
        int count = 0;
        int n = nums.length;
        int[] dp = new int[n];  //dp array and everything is null in the beginning
        for(int i = n-3; i>=0; i--){    //starts from 3rd last index as I cannot form a slice with 2 elements
            if(nums[i+2] - nums[i+1] == nums[i+1] - nums[i]){   //checking if difference between last 2 and 2nd last and i index is same or not, if yes, adding count to the the current value of i which will hold the previous continuous slice count
                dp[i] = dp[i+1] + 1;    //adding 1 to the previous count
                count = count + dp[i];  //adding the previous total of count adn current value of dp array
            }
        }
        return count;   //returning count
    }
}

//DP with space optimization
class Solution {

    //Time Complexity : 0(n) where n is the length of nums array
    //Space Complexity: 0(1)
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while coding: No

    //In brief Explain your approach

    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length < 3){
            return 0;
        }
        int count = 0;
        int n = nums.length;
        int prev = 0;   //here previous store the continuous subslices
        for(int i = 2; i < n; i++){
            if(nums[i-1] - nums[i-2] == nums[i] - nums[i-1]){
                prev = prev + 1;    //if the difference is same, than previous + 1
                count = count + prev;   //and adding initial values of count with previous
            }
            else{
                prev = 0;   //if not, then resetting prev to 0 as I need to look at another subarray with diffrent slicing
            }
        }
        return count;
    }
}
