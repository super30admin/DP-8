// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
we start with the last element.Inorder to chekc for arthimetic sequence we need to have min 3 numbers.so we start from n-3 term.
If we are at i th index then we check with i+1 index and i+2 index,if they are in sequence then we increment the count marking it a possible sequence.In this way we traverse till we reach the first element.

# Time complexity --> o(n)
# space compexity --> o(n)
class Solution(object):
    def numberOfArithmeticSlices(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        if A==None or len(A)==0:
            return 0
        out=[0 for i in range(len(A))]
        count=0
        #starting from the n-3 index element.
        for i in range(len(A)-3,-1,-1):
            if A[i+1]-A[i]==A[i+2]-A[i+1]:
                out[i]=out[i+1]+1
                count=count+out[i]
        return count