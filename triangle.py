#TiemComplexity: O(N)
#spaceComplexity: O(1)
def minimumTotal(self, triangle: List[List[int]]) -> int:
    if not triangle:
        return 0

    for i in range(len(triangle) - 2, -1, -1):
        print(i)
        for j in range(len(triangle[i + 1]) - 1):
            currMin = min(triangle[i + 1][j], triangle[i + 1][j + 1])
            triangle[i][j] += currMin
    return triangle[0][0]