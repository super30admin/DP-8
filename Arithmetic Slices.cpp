//Time Complexity- O(n)
//Space Complexity- O(1)

class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        
        int ans=0;
        int count=0;
        
        for(int i=2;i<nums.size();i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                count++;
            }
            else{
                ans+=((count)*(count+1))/2;
                count=0;
            }
        }
        ans+=((count)*(count+1))/2;
        return ans;
    }
};