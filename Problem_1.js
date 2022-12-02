// Problem1 Arithmetic Slices (https://leetcode.com/problems/arithmetic-slices/)

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/**
 * @param {number[]} nums
 * @return {number}
 */
var numberOfArithmeticSlices = function (nums) {
    if (nums === null)
        return 0;
    let n = nums.length;
    let sum = 0;
    let prev = 0;
    for (let i = 2; i < n; i++) {
        // Check the difference between pairs of numbers, if it is same, add 1 to prev combinations
        // Also add ths to sum
        if (nums[i - 2] - nums[i - 1] === nums[i - 1] - nums[i]) {
            prev = prev + 1;
            sum += prev
        } else {
            // Else set prev combinations to 0
            prev = 0;
        }
    }
    return sum;
    // let dp = new Array(n);
    // dp.fill(0);
    // for(let i=2; i<n; i++){
    //     if(nums[i-2]-nums[i-1] === nums[i-1]-nums[i]){
    //         dp[i] = dp[i-1]+1;
    //     }
    // }
    // let sum = 0;
    // const sumWithInitial = dp.reduce((accumulator, currentValue) => accumulator + currentValue,0);
    // return sumWithInitial;
};
