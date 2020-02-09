# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True
        return self.helper(root.left, root.right)
    
    def helper(self, ltree, rtree):
        if not ltree and not rtree:
            return True
        if not ltree or not rtree:
            return False
        if ltree.val == rtree.val:
            return self.helper(ltree.left, rtree.right) and self.helper(ltree.right, rtree.left)
        return False
