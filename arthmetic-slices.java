// TC: O(n)
// SC: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public int numberOfArithmeticSlices(int[] A) {
    int curr = 0, sum = 0;
    for (int i = 2; i < A.length; i++) {
        if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
            curr += 1;
            sum += curr;
        } else {
            curr = 0;
        }
    }
    return sum;
}
