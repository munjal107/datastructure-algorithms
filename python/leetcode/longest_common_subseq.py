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
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        r = len(text1)
        c = len(text2)
        dp = [[0 for _ in range(c+1)] for _ in range(r+1)]

        for i in range(1, r+1):
            for j in range(1, c+1):
                if text1[i-1] == text2[j-1]:
                    dp[i][j] = 1 + dp[i-1][j-1]
                else:
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1])
        return dp[r][c]
    
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


if __name__ == "__main__":
    obj = Solution()

    s1 = "abcdede"
    s2 = "acewe"
    print(obj.longestCommonSubsequence(s1, s2))
    print(obj.get_longest_common_subseq(s1, s2))
