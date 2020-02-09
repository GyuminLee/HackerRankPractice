/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode ltree, TreeNode rtree) {
        if (ltree == null && rtree == null) return true;
        if (ltree == null || rtree == null) return false;
        if (ltree.val == rtree.val) {
            return helper(ltree.left, rtree.right) && helper(ltree.right, rtree.left);
        }
        return false;
    }
}
