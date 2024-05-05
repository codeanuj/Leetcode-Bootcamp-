class Solution {
	/* This is the Node class definition
	
	class Node {
		public Node left;
		public Node right;
		public int data;

		public Node(int data) {
			this.data = data;
		}
	}
	*/

	Node findPredecessor(Node root, Node p) {
	    // add your logic here
		Node predecessor = null;
		while(root!=null){
			if(root.data<p.data){
				predecessor = root;
				root = root.right;
			}else{
				root = root.left;
			}
		}
		return predecessor;
	}
}
