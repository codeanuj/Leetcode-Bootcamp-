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
    public List<Integer> inorderTraversal(TreeNode root) {
     List<Integer> list = new ArrayList<Integer>();
       inorderTraversal(root, list);
       return list;
    }

    private void inorderTraversal(TreeNode root, List<Integer> list){
        if(root == null) return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
        return;
    }
//Iterative Solution
      public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> list = new ArrayList<Integer>();
       Stack<TreeNode> stack = new Stack<>();
       TreeNode curr_node = root;
       TreeNode temp = null;

       while(curr_node != null || !stack.isEmpty()){
           if(curr_node!=null){
               stack.push(curr_node);
               curr_node = curr_node.left;
           }
           else{
               temp = stack.pop();
               list.add(temp.val);
               if(temp.right!=null) curr_node = temp.right;
           }
       }
       return list;
    }
}
