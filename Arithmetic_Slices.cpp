// Time Complexity : O(n)
// Space Complexity : O(n): with dp array or O(1) w/o dp array
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//1. Construct an array of count where you find the difference is matching for 3 numbers in the array
//2. Increase count by 1 if no previous match was found
//3. If previous match is found add 1 to it.

//Top-down approach with variable
class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& A) {
        //edge
        if(A.size()==0){
            return 0;
        }
        
        //logic
        int size = A.size();
        int prev = 0;
        int global_count=0;
        
        for(int i=size-3; i>=0; i--){
            if(A[i+1]-A[i] == A[i+2]-A[i+1]){
                    prev= prev +1;
                    global_count += prev;
            }else{
                prev=0;
            }
        }
        return global_count;
    }
};
