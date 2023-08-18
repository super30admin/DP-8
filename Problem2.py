class Solution:
    # Time complexity: O(N^2), where N is the number of rows in the triangle.We iterate through each element in the triangle once.
    # Space complexity: O(1), as we modify the input triangle in-place without using additional space.

    def minimumTotal(self, triangle: List[List[int]]) -> int:
        # Get the number of rows in the triangle
        n = len(triangle)

        # Iterate from the second-to-last row to the first row
        for row in range(n - 2, -1, -1):
            # Iterate through each element in the current row
            for col in range(len(triangle[row])):
                # Update the current element with the minimum sum of the two possible paths
                triangle[row][col] += min(triangle[row + 1]
                                          [col], triangle[row + 1][col + 1])

        # The minimum sum will be at the top of the triangle
        return triangle[0][0]
