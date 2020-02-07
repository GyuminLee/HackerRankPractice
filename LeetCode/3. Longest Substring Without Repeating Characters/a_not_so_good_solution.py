class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s:
            return 0
        left, right = 0, 0
        max_len = 0
        seen = {}
        while right < len(s):
            if s[right] in seen:
                left = seen[s[right]] + 1
                right = left
                seen = {}
            else:
                seen[s[right]] = right
                right += 1
                max_len = max(max_len, right - left)
        return max_len
