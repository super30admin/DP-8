"""
Start from the second-last row, and move upwards
For each element, store:
triangle[i][j] += min(triangle[i+1][j], triangle[i+1][j+1])
The top element will eventually contain the minimum path sum
"""
"""
Time Complexity: O(n^2)
Space Complexity: O(1)
"""
class triangle:
    def minimumTotal(self, triangle: list[list[int]]) -> int:
        for i in range(len(triangle) - 2, -1, -1):
            for j in range(len(triangle[i])):
                triangle[i][j] += min(triangle[i+1][j], triangle[i+1][j+1])
        return triangle[0][0]

if __name__ == "__main__":
    obj = triangle()
    print(obj.minimumTotal([
        [2],
        [3,4],
        [6,5,7],
        [4,1,8,3]
    ]))  # Output: 11

    print(obj.minimumTotal([[1]]))  # Output: 1
