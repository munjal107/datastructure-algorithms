# https://leetcode.com/problems/partition-equal-subset-sum/ (416)


class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        total = sum(nums)
        # if sum is odd we cannot find solution
        # https://www.youtube.com/watch?v=obhWqDfzwQQ&list=PLEJXowNB4kPxBwaXtRO1qFLpCzF75DYrS&index=9&ab_channel=TECHDOSETECHDOSE
        if total % 2 == 1:
            return False
        total = total//2
        n = len(nums) + 1
        
        dp = [[False for j in range(total+1)] for i in range(n)]
        
        for i in range(n):
            for j in range(total+1):
                if j == 0:
                    dp[i][j] = True
                elif j - nums[i-1] < 0:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = any([dp[i-1][j], dp[i-1][j-nums[i-1]]])
        
        return dp[n-1][total]

   
    
if __name__ == '__main__':
    obj = Solution()
    n = [1,5,11,5]
    print(obj.canPartition(n))

