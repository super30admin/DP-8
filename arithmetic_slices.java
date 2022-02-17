class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length < 3) return 0; //base case, if nums is null or length of nums is less than 3, we return 0
        int count = 0; //count is initialized to 0
        int n = nums.length; // n is the length of nums
        int prev = 0; // prev is initialized to 0
        for(int i = 2; i < n; i++) { //we start from 2 and iterate through the length of the array
            if(nums[i] == nums[i - 1] || nums[i - 1] == nums[i - 2]) { //we compare the computations of the values
                prev = prev + 1; //we increment prev
                count = count + prev; //cumulative incrementing of count
            }
            else { //if diffs are not equal
                prev = 0; //prev should be set to 0
            }
        }
        return count; //in the end, we return count
    }
}
//tc and sc - O(n) and O(1)