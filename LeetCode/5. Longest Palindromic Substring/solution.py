class Solution:
    def longestPalindrome(self, s: str) -> str:
        res = ''
        for i in range(len(s)):
            candidate1 = self.helper(s, i, i)
            candidate2 = self.helper(s, i, i+1)
            curr = candidate1 if len(candidate1) > len(candidate2) else candidate2
            if len(curr) > len(res):
                res = curr
        return res
    
    def helper(self, s, i, j):
        while i >= 0 and j < len(s) and s[i] == s[j]:
            i -= 1
            j += 1
        return s[i+1: j]
