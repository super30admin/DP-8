"""
Problem : 1

Time Complexity : 
Bruteforce - O(n^2)
DP - O(n)

Space Complexity : 
Bruteforce and DP - O(1)
DP Array - O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Arithmetic Slices

# Approach - 1
# DP

class Solution(object):
    def numberOfArithmeticSlices(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        n=len(nums)
        result=0
        # dp=[0 for _ in range(n)]
        prev=0
        curr=0
        for i in range(2,n):
            temp=curr
            if nums[i]-nums[i-1]==nums[i-1]-nums[i-2]:
                curr=prev+1
                result+=curr
            else:
                curr=0
            prev=curr
        return result

# Approach - 2
# DP Array - Left to Right

class Solution(object):
    def numberOfArithmeticSlices(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        if not nums:
            return 0
        n=len(nums)
        result=0
        dp=[0 for _ in range(n)]
        for i in range(2,n):
            if nums[i]-nums[i-1]==nums[i-1]-nums[i-2]:
                dp[i]=dp[i-1]+1
                result+=dp[i]
        return result
    
# Approach - 3
# DP Array - Right to Left

class Solution(object):
    def numberOfArithmeticSlices(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        n=len(nums)
        result=0
        dp=[0 for _ in range(n)]
        for i in range(n-3,-1,-1):
            if nums[i+2]-nums[i+1]==nums[i+1]-nums[i]:
                dp[i]=dp[i+1]+1
                result+=dp[i]
        return result


# Approach - 4
# Bruteforce

class Solution(object):
    def numberOfArithmeticSlices(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        n=len(nums)
        result=0

        for i in range(0,n-2):
            for j in range(i+1,n-1):
                diff=nums[i+1]-nums[i]
                if nums[j+1]-nums[j]==diff:
                    result+=1
                else:
                    break
        return result