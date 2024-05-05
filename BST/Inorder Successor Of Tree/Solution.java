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
   // List<Node> list = new ArrayList<>();
    // returns the inorder successor of the Node x in BST (rooted at 'root')
	public Node inorderSuccessor(Node root,Node x) {
	   Node successor = null;
	   while(root != null){
	       if(x.data>=root.data) root = root.right;
	       else{
	           successor = root;
	           root =root.left;
	       }
	   }
	   return successor;
     }
}
