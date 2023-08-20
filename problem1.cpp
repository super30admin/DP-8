/*
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
*/

//brute force

#include<iostream>
#include<vector>

using namespace std;

class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        int sz = nums.size();
        int sum{};
        for(int i{};i<sz-2;++i){
            int cnt{};
            int diff = nums.at(i+1) - nums.at(i);
            //cout<<diff<<" ";
            for(int j{i+2};j<sz;++j){
                int diff_2 = nums.at(j) - nums.at(j-1);
                //cout<<diff_2<<" ";
                if(diff == diff_2){
                    //cout<<"true";
                    cnt++;
                }
                if(j==sz-1 || diff_2!=diff){
                    sum = sum + cnt;
                    cnt = 0;
                    break;
                }
            }
            //cout<<endl;
        }
        return sum;
    }
};

// DP solution 

