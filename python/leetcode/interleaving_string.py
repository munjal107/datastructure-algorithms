"""
P97
Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where they 
are divided into non-empty substrings such that:

"""

class Solution:
    def __init__(self):
        self.map = {}

    def is_interleave_string(self, s1, s2, s3, l1, l2, l3, p1, p2, p3):
        if p3 == l3:
            return True if (l1==p1 and l2==p2) else False
        
        key = str(p1) + "*" + str(p2) + "*" + str(p3)
        if self.map.get(key, -1) != -1:
            return self.map[key]
        
        if p1==l1:
            self.map[key] = s2[p2] == s3[p3]
            if self.map.get(key):
                return self.is_interleave_string(s1, s2, s3, l1, l2, l3, p1, p2+1, p3+1)
            else:
                return False
        if p2 == l2:
            self.map[key] = s1[p1] == s3[p3]
            if self.map.get(key):
                return self.is_interleave_string(s1, s2, s3, l1, l2, l3, p1+1, p2, p3+1)
            else:
                return False
        
        one = False
        two = False
        if s1[p1] == s3[p3]:
            one = self.is_interleave_string(s1, s2, s3, l1, l2, l3, p1+1, p2, p3+1)
        
        if s2[p2] == s3[p3]:
            two = self.is_interleave_string(s1, s2, s3, l1, l2, l3, p1, p2+1, p3+1)
        
        self.map[key] = one | two
        return self.map[key] 


    def isInterleave_rec(self, s1: str, s2: str, s3: str) -> bool:
        l1 = len(s1)
        l2 = len(s2)
        l3 = len(s3)
        # print(l1, l2, l3)
        if l3 != (l1+l2):
            return False
        ans = self.is_interleave_string(s1, s2, s3, l1, l2, l3, 0, 0, 0)
        return ans
    
    # Dynamic Prog
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        row, col, l = len(s1), len(s2), len(s3)
        if l != (row + col):
            return False
        
        dp = [[True for i in range(col+1)] for j in range(row+1)]

        for i in range(1, row+1):
            dp[i][0] = dp[i-1][0] and s1[i-1] == s3[i-1]
        
        
        for j in range(1, col+1):
            dp[0][j] = dp[0][j-1] and s2[j-1] == s3[j-1]

        for i in range(1, row+1):
            for j in range(1, col+1):
                dp[i][j] = (dp[i-1][j] and s1[i-1] == s3[i-1+j]) or \
                                        (dp[i][j-1] and s2[j-1] == s3[i-1+j])

        return dp[-1][-1]

if __name__ == '__main__':
    obj = Solution()
    print(obj.isInterleave("bbbcc", "bbaccbbbabcacc", "bbbbacbcccbcbabbacc"))

