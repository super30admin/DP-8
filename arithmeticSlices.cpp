#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We take a count and curr variables and start from the 3rd element in the array 
We check if the difference between the current and the previous element is equal to the diff b/w previous and (i-2)th element
We increment curr variable with 1, else we put curr = 0 and increment count with curr
*/
class Solution{
public:
    int numberOfArithmeticSlices(vector<int>& nums){
        int n = nums.size();
        int count = 0;
        int curr = 0;

        for(int i = 2; i < n; i++){
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                curr += 1;
            }else curr = 0;
            count += curr;
        }
        return count;
    }
};
