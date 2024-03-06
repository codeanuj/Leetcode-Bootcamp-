/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int currentSize = queue.size();
           // ArrayList<Node> list = new ArrayList<>();

            for(int i=0; i<currentSize; i++){
                Node node = queue.remove();
               // list.add(node);

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                
                if(i == currentSize-1) node.next = null;
                else node.next = queue.peek(); 
            }

           /* for(int i=0; i<list.size(); i++){
                if(i == list.size()-1){
                    list.get(i).next =null;
                    break;
                }
                list.get(i).next = list.get(i+1);
            }*/
        }
        return root;
    }
}
