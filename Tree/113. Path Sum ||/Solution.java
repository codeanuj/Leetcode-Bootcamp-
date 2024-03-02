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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        if(root == null) return answer;
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        findAllPath(root, targetSum-root.val, list, answer);
        return answer;
    }

    private void findAllPath(TreeNode root, int target, List<Integer> list, List<List<Integer>> answer){
        if(root.left == null && root.right == null && target == 0){
            answer.add(new ArrayList<Integer>(list));
            return;
        }

        if(root.left == null && root.right == null && target != 0){
            return;
        }

        if(root.left != null){
            list.add(root.left.val);
            findAllPath(root.left, target-root.left.val, list, answer);
            list.remove(list.size()-1);
        } 
        if(root.right != null){
            list.add(root.right.val);
            findAllPath(root.right, target-root.right.val, list, answer);
            list.remove(list.size()-1);
        } 
        return;
    }
}
