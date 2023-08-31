#include<vector>
#include<iostream>

using namespace std;

//brute force recursion

class Solution {
    //int min_sum{INT_MIN};
    int helper(vector<vector<int>>& triangle,int sum,int r,int c){
        //base
        if(r == triangle.size()-1){
            return sum+triangle.at(r).at(c);
        }
        //logic
        return min(helper(triangle,sum+triangle.at(r).at(c),r+1,c),helper(triangle,sum+triangle.at(r).at(c),r+1,c+1));
    }
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        return helper(triangle,0,0,0);
        //return min_sum;
    }
};

//Bottom up DP

class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        int sz = triangle.size();
        if(sz == 1) return triangle.at(sz-1).at(sz-1);

        int arr_size = triangle.at(sz-1).size();
        vector<int> dp_arr(arr_size+1,0);
        for(int i{sz};i>=1;--i){
            for(int j{};j<triangle.at(i-1).size();++j){
                dp_arr[j] = triangle.at(i-1).at(j) + min(dp_arr.at(j),dp_arr.at(j+1));
            }
        }
        return dp_arr[0];
    }
};



