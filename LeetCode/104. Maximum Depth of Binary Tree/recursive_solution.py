class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        if not root: return 0
        return max(map(self.maxDepth, (root.left, root.right))) + 1
