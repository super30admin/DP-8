#All TC passed on leetcode

class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:

         #Here we use DP appraoch. We check if cur index and prev index diff is same as diff b/w 2 nums prev to current. If yes then we assign 1 plus dp value at prev index. We dont use extra space for dp array, as we depend only on previous count.
        #Time complexity - O(n)
        #Space complexity - O(1)
        n = len(nums)
        if not nums or n<=2:
            return 0 

        prev = 0 
        cur = 0
        res = 0
        for i in range(2, n):
            if nums[i]-nums[i-1]==nums[i-1]-nums[i-2]:
                cur = prev+1
                res += cur
            else:
                cur = 0
            prev = cur
        return res


        #----------------------------------------OR--------------------------------------------


        #Here we use DP appraoch. We check if cur index and prev index diff is same as diff b/w 2 nums prev to current. If yes then we assign 1 plus dp value at prev index. 
        #Time complexity - O(n)
        #Space complexity - O(n) to store indivdual sums
        n = len(nums)
        if not nums or n<=2:
            return 0 

        dp = [0]*n
        res = 0
        for i in range(2, n):
            if nums[i]-nums[i-1]==nums[i-1]-nums[i-2]:
                dp[i] = dp[i-1]+1
                res += dp[i]
        return res



#----------------------------------------OR--------------------------------------------


        #Brute force - Here we fix i at an index and check all nums after i, if their diff is constact and same as i and i+1.
        #Time complexity - O(n^2)
        #Space complexity - O(1)
        res = 0
        n = len(nums)

        for i in range(n-2):
            for j in range(i+2, n):
                if nums[i+1]-nums[i]==nums[j]-nums[j-1]:
                    res+=1
                else:
                    break
        return res
