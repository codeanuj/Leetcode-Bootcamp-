//Node is as follows:
class Node{
	int data;
	Node left,right;
	Node(int d){
		data=d;
		left=right=null;
	}
}
*/
class Solution
{
    List<Node> list = new ArrayList<>();
    // returns the inorder successor of the Node x in BST (rooted at 'root')
	public Node inorderSuccessor(Node root,Node x)
         {
             getInorderTraversal(root);
             for(int i=0; i<list.size()-1; i++){
                 Node current = list.get(i);
                 if(current.data == x.data) return list.get(i+1);
             }
             return null;
         }
         
    public void getInorderTraversal(Node root){
        if(root == null) return;
        getInorderTraversal(root.left);
        list.add(root);
        getInorderTraversal(root.right);
        return;
    }     
}
