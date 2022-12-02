// Problem 2 Triangle (https://leetcode.com/problems/triangle/)

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/**
 * @param {number[][]} triangle
 * @return {number}
 */
 var minimumTotal = function (triangle) {
    if (triangle === null || triangle.length === 0) {
        return 0;
    }
    let n = triangle.length;
    // Start from second last row and change value to minimum
    for (i = n - 2; i >= 0; i--) {
        for (let j = 0; j <= i; j++) {
            triangle[i][j] = Math.min(triangle[i][j] + triangle[i + 1][j], triangle[i][j] + triangle[i + 1][j + 1])
        }
    }
    return triangle[0][0];
};