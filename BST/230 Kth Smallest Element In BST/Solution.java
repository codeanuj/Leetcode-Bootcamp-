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
    int counter = 0;
    int output = -1;
    public int kthSmallest(TreeNode root, int k) {
        getKthElement(root, k);
        return output;
    }

    public void getKthElement(TreeNode root, int k){
        if(root.left != null) getKthElement(root.left, k);

        counter++;

        if(counter == k){
            output = root.val;
            return;
        }

        if(root.right != null) getKthElement(root.right, k);
        return;
    }
}
