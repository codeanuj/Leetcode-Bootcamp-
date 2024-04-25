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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int[] postIndex = {postorder.length-1};
        return constructTree(postorder, inorder, 0, postorder.length-1, postIndex);
    }

    private TreeNode constructTree(int[] postorder, int[] inorder, int start, int end, int[] postIndex){
        if(start>end || postIndex[0]<0) return null;

        int i=-1;
        for(i=0; i<inorder.length; i++){
            if(inorder[i] == postorder[postIndex[0]]) break;
        }

        TreeNode root = new TreeNode(postorder[postIndex[0]]);
        postIndex[0]-=1;
        
        root.right = constructTree(postorder, inorder, i+1, end, postIndex);
        root.left = constructTree(postorder, inorder, start, i-1, postIndex);
        
        return root;
    }
}
