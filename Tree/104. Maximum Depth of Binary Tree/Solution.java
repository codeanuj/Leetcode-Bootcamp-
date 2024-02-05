/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return getMaximumDepth(root);
    }
    private int getMaximumDepth(TreeNode root){
        if(root == null) return 0;

        int leftHeight = getMaximumDepth(root.left);
        int rightHeight = getMaximumDepth(root.right);

        return (Math.max(leftHeight, rightHeight))+1;
    }
}
