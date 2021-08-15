class Solution {

public:
int minimumTotal(vector<vector<int>>& triangle) {
	for(int i = triangle.size() - 2; i >= 0; i--){
		for(int j = 0; j < triangle[i].size(); j++){
			triangle[i][j] += min(triangle[i+1][j], triangle[i+1][j+1]);
		}
	}
	return triangle[0][0];
}
};

/*
In-place dynamic programming approach. Instead of using a new vector to store the intermediate results, we simply use the triangle. We traverse it from the bottom up, modifying each entry so that it contains the length of the shortest path from it to the bottom. At the end of the process, the value in the top of the triangle is the result. O(n^2) time, O(1) space.

int minimumTotal(vector<vector<int>>& triangle) {
	for(int i = triangle.size() - 2; i >= 0; i--){
		for(int j = 0; j < triangle[i].size(); j++){
			triangle[i][j] += min(triangle[i+1][j], triangle[i+1][j+1]);
		}
	}
	return triangle[0][0];
}

*/
