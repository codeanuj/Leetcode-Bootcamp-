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
    public int sumRootToLeaf(TreeNode root) {
        int[] result = {0};
        getSumOfPath(root, ""+Integer.toString(root.val), result);   
        return result[0];     
    }

    private void getSumOfPath(TreeNode root, String currentPath, int[] result){
        if(root.left == null && root.right == null){
          result[0] += Integer.parseInt(currentPath, 2);
          return;
        }
        
        if(root.left != null) getSumOfPath(root.left, currentPath+String.valueOf(root.left.val), result);
        if(root.right != null) getSumOfPath(root.right, currentPath+String.valueOf(root.right.val), result);
    
        return;

    }
}
