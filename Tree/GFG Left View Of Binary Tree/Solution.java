
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<Integer> answer = new ArrayList<Integer>();
      findLeftView(root, 0, answer);
      return answer;
    }
    
    private void findLeftView(Node root, int curr_level, ArrayList<Integer> answer){
        if(root == null) return;
        //If list size is current level 0 means current level 0 has not been added in list
        if(answer.size()==curr_level){
            answer.add(root.data);
        }
        
        findLeftView(root.left, curr_level+1, answer);
        findLeftView(root.right, curr_level+1, answer);
        
        return;
    }
}
