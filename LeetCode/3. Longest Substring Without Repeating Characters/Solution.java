class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int maxlen = 0;
        
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right);
            right++;
            maxlen = Math.max(maxlen, right - left);
        }
        return maxlen;
    }
}
