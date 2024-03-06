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
    public int sumOfLeftLeaves(TreeNode root) {
        return findSum(root, false);        
    }

    private int findSum(TreeNode root, boolean isLeft){
        if(root == null) return 0;
        if(root.left==null && root.right==null){
            return isLeft?root.val:0;
        }

        int a = findSum(root.left, true);
        int b = findSum(root.right, false);
        return a+b;
    }



    //BY BFS

     public int sumOfLeftLeaves(TreeNode root) {
        int answer=0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, false));

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            boolean isLeft = pair.isLeft;
            if(node.left == null && node.right==null && isLeft) answer+=node.val;
            if(node.left!=null) queue.offer(new Pair(node.left, true));
            if(node.right!=null) queue.offer(new Pair(node.right, false));
        }      
        return answer;    
    }

    class Pair{
        TreeNode node;
        boolean isLeft;

        public Pair(TreeNode node, boolean isLeft){
            this.node = node;
            this.isLeft = isLeft;
        }
}
