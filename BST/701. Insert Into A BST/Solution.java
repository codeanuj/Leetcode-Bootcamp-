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
    public TreeNode insertIntoBST(TreeNode root, int val) {
      /*  if(root == null) return new TreeNode(val);

        if(root.val>val) 
          root.left = insertIntoBST(root.left, val);
        else 
          root.right = insertIntoBST(root.right, val);
        return root;
        */

        if(root == null) return new TreeNode(val);
        TreeNode current_node = root;
        TreeNode previous = null;
        while(current_node != null){
            
            previous = current_node;

            if(current_node.val>val){
                current_node = current_node.left;

            }else{
                current_node = current_node.right;
            }
        }
       
        if(previous.val>val) previous.left = new TreeNode(val);
        else previous.right = new TreeNode(val);
        
        return root;
    }
}
