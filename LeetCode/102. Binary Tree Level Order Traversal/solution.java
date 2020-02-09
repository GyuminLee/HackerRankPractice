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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> wrapList = new ArrayList<>();
        
        if (root == null) return wrapList;
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> currList = new ArrayList<>();
            int cnt = queue.size();
            for (int i = 0; i < cnt; i++) {
                TreeNode node = queue.poll();
                currList.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            wrapList.add(currList);
        }
        return wrapList;
    }
}
