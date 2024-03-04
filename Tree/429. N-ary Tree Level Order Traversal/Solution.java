/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        Queue<Node> queue = new LinkedList<>();

        if(root == null) return answer;
        Node current_node = null;
        queue.add(root);
        
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while(size > 0){
                current_node = queue.poll();
                list.add(current_node.val);
                for(Node child:current_node.children) queue.add(child);
                size--;
            }
            answer.add(list);

        }
        return answer;
        
    }
}
