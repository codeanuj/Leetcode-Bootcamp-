/*Complete The Function Provided
Given Below is The Node Of Tree
class Node
{
    int data;
    Node left, right;
    public Node(int data)
    {
        this.data = data;
         left = right = null;
    }
}*/


class Solution{
    //Function to return list containing elements of right view of binary tree.
    ArrayList<Integer> rightView(Node node) {
        //add code here.
        ArrayList<Integer> answer = new ArrayList<Integer>();
        findRightView(node, 0, answer);
        return answer;        
    }

    private void findRightView(Node root, int curr_level, List<Integer> answer){
        if(root == null) return;
        if(answer.size() == curr_level) answer.add(root.data);
        findRightView(root.right, curr_level+1, answer);
        findRightView(root.left, curr_level+1, answer);
        return;
    }
}
