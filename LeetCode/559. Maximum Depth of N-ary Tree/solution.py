"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution:
    def maxDepth(self, root: 'Node') -> int:
        if not root:
            return 0
        return max(map(self.maxDepth, root.children or [None])) + 1

# Note that we use a `or [None]` here. The reason is root.children will be None at some point, but
# `map` requires iterable objects. None is not iterable, but [None] is a list, list is iterable.
