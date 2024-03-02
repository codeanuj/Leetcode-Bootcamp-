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
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] parents = new int[2];
        int[] levels = new int[2];
        findCousins(root, new TreeNode(-1), x, y, 0, parents, levels);
        return (parents[0] != parents[1]) && (levels[0] == levels[1]);
    }

    private void findCousins(TreeNode root, TreeNode currentParent, int x, int y, int height, int[] parents, int[] levels){
        if(root == null) return;

        // condition if you found x and y earlier
        if(parents[0]!=0 && parents[1]!=0) return;
        
        if(root.val == x){
            parents[0] = currentParent.val;
            levels[0] = height;
        }
         if(root.val == y){
            parents[1] = currentParent.val;
            levels[1] = height;
        }
        
        findCousins(root.left, root, x, y, height+1, parents, levels);
        findCousins(root.right, root, x, y, height+1, parents, levels);
        return;
    }
}
