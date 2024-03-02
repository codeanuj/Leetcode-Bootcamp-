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
    public boolean isUnivalTree(TreeNode root) {
        return isUnivaluedTree(root, root.val);        
    }

    private boolean isUnivaluedTree(TreeNode root, int val){
        if(root == null) return true;
        if(root.val != val) return false;

        boolean leftAns = isUnivaluedTree(root.left, val);
        boolean rightAns = isUnivaluedTree(root.right, val);

        return (leftAns && rightAns);
    }
}
