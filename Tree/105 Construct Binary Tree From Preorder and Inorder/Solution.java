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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       int[] preIndex ={0};
       return constructTree(preorder, inorder, preIndex, 0, inorder.length-1);
    

    }

    private TreeNode constructTree(int[] preorder, int[] inorder, int[] preIndex, int start, int end){
        if(preIndex[0] >= preorder.length || start > end) return null;
        int inIndex=-1;
        for(int i=0; i<inorder.length; i++){
            if(inorder[i] == preorder[preIndex[0]]){
                inIndex=i;
                break;
            }
        } 
        TreeNode root = new TreeNode(preorder[preIndex[0]]);
        preIndex[0]+=1;
        
        root.left = constructTree(preorder, inorder, preIndex ,start, inIndex-1);
        root.right = constructTree(preorder, inorder, preIndex, inIndex+1, end);
        return root;
    }
}
