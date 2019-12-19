class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        sign = 1 if x > 0 else -1
        x *= sign
        rev = 0
        while x != 0:
            tail = x % 10
            new_rev = rev * 10 + tail
            if new_rev > 2 ** 31 - 1:
                return 0
            x /= 10
            rev = new_rev
        return rev * sign
