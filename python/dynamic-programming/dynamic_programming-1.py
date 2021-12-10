import sys

class DynamicProg:
    def recursive_fib(self, n):
        if n<=1:
            return n
        else:
            return self.recursive_fib(n-1) + self.recursive_fib(n-2)

    # https://www.geeksforgeeks.org/overlapping-subproblems-property-in-dynamic-programming-dp-1/
    # dynamic programming
    def dynamic_fib_1(self, n, lookup):
        if n==0 or n==1:
            lookup[n] = n
        
        if lookup[n] is None:
            lookup[n] = self.dynamic_fib_1(n-1, lookup) + self.dynamic_fib_1(n-2, lookup)

        return lookup[n]
    
    # longest common subseq
    def longest_common_sub(self, s1, s2, x, y):
        if x==0 or y==0:
            return 0
        elif s1[x-1] == s2[y-1]:
            return 1 + self.longest_common_sub(s1, s2, x-1, y-1)
        else:
            return max(self.longest_common_sub(s1, s2, x-1, y), self.longest_common_sub(s1, s2, x, y-1))
    
    # by dyynamic programming
    # https://www.youtube.com/watch?v=LAKWWDX3sGw&ab_channel=TECHDOSE
    def dynamic_lcs(self, s1, s2):
        m = len(s1)
        n = len(s2)

        lcs = [[0] * (n+1)] * (m+1)
        for i in range(1,m+1):
            for j in range(1,n+1):
                if s1[i-1] == s2[j-1]:
                    lcs[i][j] = 1 + lcs[i-1][j-1]
                else:
                    lcs[i][j] = max(lcs[i-1][j], lcs[i][j-1])
        print("longest lcs :", lcs[m][n])

    # min cost recursive approach
    # https://www.geeksforgeeks.org/min-cost-path-dp-6/
    def min_cost_recursive(self, cost, m, n):
        if m<0 or n<0:
            return sys.maxsize
        elif m==0 and n==0:
            return cost[m][n]
        else:
            return cost[m][n] + min(self.min_cost_recursive(cost, m-1, n-1), 
                                    self.min_cost_recursive(cost, m-1,n),
                                    self.min_cost_recursive(cost, m, n-1)
                                    )

    def min_cost_dynamicp(self, cost, m, n):
        tc = [[0 for j in range(n+1)] for i in range(m+1)]
        tc[0][0] = cost[0][0]

        # Initialize first column of total cost(tc) array
        for i in range(1, m+1):
            tc[i][0] = tc[i-1][0] + cost[i][0]
    
        # Initialize first row of tc array
        for j in range(1, n+1):
            tc[0][j] = tc[0][j-1] + cost[0][j]

        # Construct rest of the tc array
        for i in range(1, m+1):
            for j in range(1, n+1):
                tc[i][j] = min(tc[i-1][j-1], tc[i-1][j], tc[i][j-1]) + cost[i][j]
    
        return tc[m][n]

    # Space optimized
    # # For 1st column
    # for i in range(1, row):
    #     cost[i][0] += cost[i - 1][0]
 
    # # For 1st row
    # for j in range(1, col):
    #     cost[0][j] += cost[0][j - 1]
 
    # # For rest of the 2d matrix
    # for i in range(1, row):
    #     for j in range(1, col):
    #         cost[i][j] += (min(cost[i - 1][j - 1],
    #                        min(cost[i - 1][j],
    #                            cost[i][j - 1])))
 
    # # Returning the value in
    # # last cell
    # return cost[row - 1][col - 1]

    # https://www.geeksforgeeks.org/coin-change-dp-7/
    # coin-change recursive
    def coin_change_recursive(self, coins, m, n):
        if n==0:
            return 1
        if n<0:
            return 0
        
        if m<=0 and n>=1:
            return 0
        
        return self.coin_change_recursive(coins, m-1, n) + self.coin_change_recursive(coins, m, n-coins[m-1])

    def coin_change_dynamicp(self, coins, amount):
        n = amount + 1
        m = len(coins) + 1
        dp = [[0 for j in range(n)] for i in range(m)]

        dp[0][0] = 1
        for i in range(1, n):
            dp[0][i] = 0
        
        for j in range(1, m):
            dp[j][0] = 1
        
        for i in range(1, m):
            for j in range(1,n):
                if j>=coins[i-1]:
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j]
        
        return dp[m-1][n-1]

    def knapsack_recursive(self, wt, profit, w, n):
        if w==0 or n==0:
            return 0
        
        if wt[n-1] > w:
            return self.knapsack_recursive(wt, profit, w, n-1)
        
        else:
            return max(self.knapsack_recursive(wt, profit, w, n-1), \
                            profit[n-1] + self.knapsack_recursive(wt, profit, w-wt[n-1], n-1))

    def knapsack_dynamicp(self, wt, profit, w):
        m = len(wt) + 1
        n = len(profit) + 1
        
        dp = [[0 for j in range(n)] for i in range(m)]

        for i in range(m):
            for j in range(n):
                if i==0 or j==0:
                    dp[i][j] = 0
                elif wt[i-1] > j:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = max(dp[i-1][j], profit[i-1] + dp[i-1][w-wt[i-1]])

        return dp[m-1][n-1]


if __name__ == '__main__':
    dyp = DynamicProg()
    n = 10
    for i in range(n):
        print(dyp.recursive_fib(i), end = " ")
    print()

    lookup = [None] * 100
    print(dyp.dynamic_fib_1(9, lookup))

    s1 = "AGGTABdd"
    s2 = "GXTXAYBd"
    print("LCS :",dyp.longest_common_sub(s1, s2, len(s1), len(s2)))
    dyp.dynamic_lcs(s1, s2)

    print("min cost")
    cost= [ [1, 2, 3],
            [4, 8, 2],
            [1, 5, 3] ]
    print(dyp.min_cost_recursive(cost, 2, 2))
    print(dyp.min_cost_dynamicp(cost, 2, 2))

    print("Coin Change prob")
    arr = [1, 2, 3]
    m = len(arr)
    print(dyp.coin_change_recursive(arr, m, 4))
    arr = [1, 2, 3]
    print(dyp.coin_change_dynamicp(arr, 6))

    # knapsack
    print("Knapsack")
    val = [60, 100, 120]
    wt = [10, 20, 30]
    W = 50
    n = len(val)
    print(dyp.knapsack_recursive(wt, val, W, n))
    print(dyp.knapsack_dynamicp(wt, val, W))
