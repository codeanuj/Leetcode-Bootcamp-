/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> answer = new ArrayList<Integer>();
    Map<TreeNode, TreeNode> map = new HashMap<>();
    Set<TreeNode> visited = new HashSet<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        createParentChildMap(root, null);
        iterateTree(target, k);     
        return answer;   
    }
//create parent child map to traverse upwards
    private void createParentChildMap(TreeNode current_node, TreeNode parent_node){
        if(current_node==null) return;
        map.put(current_node, parent_node);
        createParentChildMap(current_node.left, current_node);
        createParentChildMap(current_node.right, current_node);
        return;
    }
//Travese the tree and to stop infinite loop add the element in set which is already visited.
    private void iterateTree(TreeNode current, int distance){
        if(current == null || visited.contains(current)) return;
        if(distance == 0){
            answer.add(current.val);
            return;
        } 
        visited.add(current);
        iterateTree(current.left, distance-1);
        iterateTree(current.right, distance-1);
        iterateTree(map.get(current), distance-1);
        return;
    }
}
