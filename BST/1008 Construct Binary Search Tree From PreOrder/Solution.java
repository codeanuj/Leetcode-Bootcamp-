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
    public TreeNode bstFromPreorder(int[] preorder) {
        return constructTree(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    private TreeNode constructTree(int[] preorder, int value, int[] index){
        if(index[0]>=preorder.length || preorder[index[0]]>value) return null;

        TreeNode root = new TreeNode(preorder[index[0]]);
        index[0]+=1;

        root.left = constructTree(preorder, root.val, index);
        root.right = constructTree(preorder, value , index);

        return root;

    }
}
