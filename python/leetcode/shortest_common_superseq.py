""" 
Given two strings text1 and text2, return the length of their longest common subsequence. 
If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some 
characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

Example 1:
Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.

"""

class Solution:
    def get_longest_common_subseq(self, s1, s2):
        r = len(s1)
        c = len(s2)
        dp = [["" for _ in range(c+1)] for _ in range(r+1)]
        for i in range(1, r+1):
            for j in range(1, c+1):
                if s1[i-1] == s2[j-1]:
                    dp[i][j] = dp[i-1][j-1] + s1[i-1]
                else:
                    dp[i][j] = dp[i-1][j] if len(dp[i-1][j]) > len(dp[i][j-1]) else dp[i][j-1]
        return dp[-1][-1]

    def shortestCommonSupersequence(self, str1: str, str2: str) -> str:
        lcs = self.get_longest_common_subseq(str1, str2)
        #print(lcs)
        ans = ""
        p1 = 0
        p2 = 0
        for c in lcs:
            while str1[p1] != c:
                ans += str1[p1]
                p1 += 1
            while str2[p2] != c:
                ans += str2[p2]
                p2 += 1
            
            ans += c
            p1 += 1
            p2 += 1
        
        while p1 < len(str1):
            ans += str1[p1]
            p1 += 1
        while p2 < len(str2):
            ans += str2[p2]
            p2 += 1


        return ans


if __name__ == "__main__":
    obj = Solution()
    s1 = "abac"
    s2 = "cab"

    print(obj.shortestCommonSupersequence(s1, s2))
