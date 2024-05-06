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
    public boolean isValidBST(TreeNode root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean checkBST(TreeNode root, long leftBoundary, long rightBoundary){
        if(root == null) return true;
        if(root.val<=leftBoundary || root.val>=rightBoundary) return false;
        return checkBST(root.left, leftBoundary, root.val) && checkBST(root.right, root.val, rightBoundary);
    }
}
