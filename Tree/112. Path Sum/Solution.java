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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return isPathSum(root, targetSum-root.val);
    }

    private boolean isPathSum(TreeNode root, int target){
        if(root.left == null && root.right ==null && target == 0) return true;
        if(root.left == null && root.right == null) return false;
        boolean left = false;
        boolean right = false;
        if(root.left!=null) {
            left = isPathSum(root.left, target-root.left.val);
        } 
        if(root.right!=null) {
            right = isPathSum(root.right, target-root.right.val);
        }

        return left || right;
    }
}
