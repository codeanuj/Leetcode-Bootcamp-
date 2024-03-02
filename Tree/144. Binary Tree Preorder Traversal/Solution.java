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
    public List<Integer> preorderTraversal(TreeNode root) {
       List<Integer> list = new ArrayList<Integer>(); 
        getPreorder(root, list);
        return list;
    }

    private void getPreorder(TreeNode root, List<Integer> list){
        if(root == null) return;
        list.add(root.val);
        getPreorder(root.left, list);
        getPreorder(root.right, list);

    }
}

//Iterative Solution
    public List<Integer> preorderTraversalWithIteration(TreeNode root) {
       List<Integer> list = new ArrayList<Integer>(); 
       if(root==null) return list;
       Stack<TreeNode> stack = new Stack<>();
       stack.push(root);
       while(!stack.isEmpty()){
           TreeNode curr_node = stack.pop();
           list.add(curr_node.val);
           if(curr_node.right!=null) stack.push(curr_node.right);
           if(curr_node.left!=null) stack.push(curr_node.left);
       }
       return list;
}
