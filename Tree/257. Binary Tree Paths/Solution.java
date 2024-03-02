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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        getRootToLeafPath(root, ""+String.valueOf(root.val), list);
        return list;
    }

    private void getRootToLeafPath(TreeNode root, String path, List<String> list){
        if(root.left == null && root.right == null){
            list.add(path);
            return;
        }

        if(root.left != null) getRootToLeafPath(root.left, path+"->"+String.valueOf(root.left.val), list);
        if(root.right != null) getRootToLeafPath(root.right, path+"->"+String.valueOf(root.right.val), list);
        return;
    }
}
