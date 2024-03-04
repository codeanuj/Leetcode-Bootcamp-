//User function Template for Java

/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution
{
    //Function to return the level order traversal of a tree.
    static ArrayList <Integer> levelOrder(Node root) 
    {
        // Your code here
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        
        if(root == null) return answer;
        queue.add(root);
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            answer.add(node.data);
            
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
        }
        return answer;
    }
}
