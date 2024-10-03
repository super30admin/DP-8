// Time Complexity - O(n^2)
// SPace Complexity - O(1)
class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        int n = nums.size();
        int count = 0;
        for(int i = 0; i < n-2; i++){
            int diff = nums[i+1] - nums[i];
            for(int j = i+1; j < n-1; j++){
                if(nums[j+1] - nums[j] == diff)
                    count++;
                else break;
            }
        }
        return count;
    }
};
