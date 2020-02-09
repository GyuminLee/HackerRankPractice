# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        curr_level = [root]
        res = []
        while curr_level:
            next_level = []
            curr_nodes = []
            for node in curr_level:
                curr_nodes.append(node.val)
                if node.left:
                    next_level.append(node.left)
                if node.right:
                    next_level.append(node.right)
            res.append(curr_nodes)
            curr_level = next_level
        return res
