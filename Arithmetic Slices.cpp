//time: O(n)
//space: O(1)
class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        int diff = 5000;
        int result = 0;
        int curr = 0;
        int n = nums.size();
        for(int i = n-2; i >= 0; i--) {
            if(diff == (nums[i] - nums[i+1])) {
                curr++;
                result += curr;
            }
            else {
                diff = nums[i] - nums[i+1];
                curr = 0;
            }
        }
        return result;
    }
};