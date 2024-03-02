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
    public List<Integer> postorderTraversal(TreeNode root) {
          List<Integer> list = new ArrayList<Integer>();
        postorderTraversal(root, list);
        return list;
    }

    private void postorderTraversal(TreeNode root, List<Integer> list){
        if(root == null) return;
        postorderTraversal(root.left, list);
        postorderTraversal(root.right, list);
        list.add(root.val);
        return;
    }


    //Iterative Solution

    public List<Integer> postorderTraversalWithIteration(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr_node = stack.pop();
            list.add(curr_node.val);
            if(curr_node.left!=null) stack.push(curr_node.left);
            if(curr_node.right!=null) stack.push(curr_node.right);
        }
        Collections.reverse(list);
        return list;
    }
}


    public List<Integer> postorderTraversalWithoutReversing(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current_Node =root;
        TreeNode temp=null;
        while(current_Node != null || !stack.isEmpty()){
            if(current_Node != null){
                stack.push(current_Node);
                current_Node = current_Node.left;
            }else{
                temp = stack.peek().right;
                if(temp == null){
                    temp = stack.pop();
                    list.add(temp.val);
                    while(!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        list.add(temp.val);
                    }

                }else{
                    current_Node = temp;
                }
            }          
        }
        return list;
    }
