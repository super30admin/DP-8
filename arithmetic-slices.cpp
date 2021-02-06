//Time - O(n)
//Space - O(1)
class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& A) {
        if(A.size() <3) {
            return 0;
        }
        int j = 0;
        int sum = 0;
        for(int i=0;i<A.size()-1;){
            int diff = A[i+1]-A[i];
            int cnt = 0;
            for(j = i+1;j<A.size();j++){
                if(A[j]-A[j-1] != diff) break;
                cnt++;
            }
            if(j-i>=3){
                sum = sum + (cnt*(cnt-1))/2;
            }
            i = j-1;
                
        }
        return sum;
        
        
    }
};