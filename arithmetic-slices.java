// Time - O(N), Space - O(1)

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3) {
            return 0;
        }
    
        int prev = 0, curr = 1;
        int count = 0;
        for(int i=2;i<A.length; i++) {            
            if(A[i] - A[i-1] == A[i-1] - A[i-2]) {
                curr = prev + 1;
                count += curr;
                prev = curr;
            }
            else {
                prev = 0;
            }
        }
        
        return count;
    }
}

// Time - O(N^2), Space -O(1)

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3) {
            return 0;
        }
        
        int count = 0;
        
        for(int i=0;i<A.length - 2; i++) {
            int diff = A[i+1] - A[i];
            for(int j=i+1;j<A.length - 1;j++) {
                if(A[j+1]- A[j] == diff) {
                count++;
                }
                else {
                    break;
                }
            }
            
        }
        
        return count;
    }
}
