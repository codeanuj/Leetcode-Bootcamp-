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
       Stack<TreeNode> stack = new Stack<>();
       if(root == null) return list;

       //Add Left Subtree of root node
       addLeftSubTree(stack, root);

       while(!stack.isEmpty()){
           //If left child is null pop the top node and add it
           TreeNode currentNode = stack.pop();
           list.add(currentNode.val);
           // if root right is not null add the leftsubtree of right child
           if(currentNode.right != null) addLeftSubTree(stack, currentNode.right);
        }
       return list;
    }

    private void addLeftSubTree(Stack<TreeNode> stack, TreeNode currentNode){
        stack.push(currentNode);
        while(currentNode.left != null){
            stack.push(currentNode.left);
            currentNode = currentNode.left;
        }
    }
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
