class Solution:
    def isPalindrome(self, s: str) -> bool:
        pure_s = ''.join([ch for ch in s if ch.isalnum()]).lower()
        return pure_s == pure_s[::-1]
