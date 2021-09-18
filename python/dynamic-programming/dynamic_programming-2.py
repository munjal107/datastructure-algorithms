# given array find subset whose sum equals target
def subset_sum(nums, target_sum):
    n = len(nums) + 1
    t = target_sum + 1

    dp = [[False for i in range(t)] for j in range(n)]
    for i in range(n):
        dp[i][0] = True
    
    for i in range(1,n):
        for j in range(1, t):
            if j - nums[i-1] < 0:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = any([dp[i-1][j], dp[i-1][j-nums[i-1]]])

    print(dp[n-1][t-1])

# count subsets with given sum
def count_subsets_with_given_sum(nums, target):
    n = len(nums) + 1
    t = target + 1
    dp = [[0 for i in range(t)] for j in range(n)]

    for i in range(n):
        dp[i][0] = 1
    
    for i in range(1, n):
        for j in range(1, t):
            if j - nums[i-1] < 0:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]]

    print("subsets with given sum : ", dp[n-1][t-1])

# https://www.youtube.com/watch?v=FB0KUhsxXGY
# divide array into two subsets such that diff. is minimized
def min_subset_sum_difference(nums):
    total = sum(nums)
    t = total + 1
    n = len(nums) + 1

    dp = [[False for i in range(t)] for j in range(n)]
    for i in range(n):
        dp[i][0] = True

    for i in range(1, n):
        for j in range(1, t):
            if j - nums[i-1] < 0:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = any([ dp[i-1][j], dp[i-1][j-nums[i-1]] ])

    diff = 10e7
    for i in range(total//2 + 1):
        temp = total - 2*i
        if dp[-1][j] == True and temp < diff:
            diff = temp
    
    print("Min Diff : ", diff)


# find the max profit obtained by cutting the rod into pieces and selling
def max_profit_by_cutting_rod(lts, prices, rod_length):
    n = len(lts)

    dp = [[0 for i in range(rod_length+1)] for j in range(n+1)]
    for i in range(n):
        dp[i][0] = 0
    
    for i in range(1, n+1):
        for j in range(1, rod_length+1):
            if j - lts[i-1] < 0:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(dp[i-1][j], prices[i-1] + dp[i][j-lts[i-1]])

    print("Max Rod Profit : ",dp[n][rod_length])

if __name__ == '__main__':
    nums = [1, 3, 4, 2, 6, 8]
    t = 11
    subset_sum(nums, t)

    nums = [1,2,1, 1]
    t = 3
    count_subsets_with_given_sum(nums, t)

    nums = [2, 4, 2, 3]
    min_subset_sum_difference(nums)

    lts = [1,2,3,4]
    prices = [1, 5, 8, 9]
    max_profit_by_cutting_rod(lts, prices, 4)