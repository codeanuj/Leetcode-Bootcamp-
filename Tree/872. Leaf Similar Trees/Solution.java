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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> listOfTreeOne = new ArrayList<>();
        List<Integer> listOfTreeTwo = new ArrayList<>();

        findLeaves(root1, listOfTreeOne);
        findLeaves(root2, listOfTreeTwo);
        return listOfTreeOne.equals(listOfTreeTwo);        
    }

    private void findLeaves(TreeNode root, List<Integer> list){
        if(root == null) return;
        if(root.left == null && root.right == null){
            list.add(root.val);
            return;
        }

        findLeaves(root.left, list);
        findLeaves(root.right, list);

        return;
    }
}
