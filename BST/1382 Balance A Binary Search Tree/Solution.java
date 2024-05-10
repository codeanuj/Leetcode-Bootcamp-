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

    List<Integer> list = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        getInorderTraversal(root);
        return constructBalancedBST(list, 0 , list.size()-1);
    }

    private void getInorderTraversal(TreeNode root){
        if(root == null) return;

        getInorderTraversal(root.left);
        list.add(root.val);
        getInorderTraversal(root.right);

        return;
    }

    private TreeNode constructBalancedBST(List<Integer> list, int start, int end){
        if(start>end) return null;
        
        int mid = start +(end-start)/2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = constructBalancedBST(list, start, mid-1);
        node.right = constructBalancedBST(list, mid+1, end);
        return node;
    }
}
