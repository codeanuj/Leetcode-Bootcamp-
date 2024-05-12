//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class BSTInfo{
    int size;
    int maxValue;
    int minValue;
    boolean isBST;
    
    public BSTInfo(int size, int maxValue, int minValue, boolean isBST){
        this.size = size;
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.isBST = isBST;
    }
}
class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root){
        // Write your code here
        return findLargetSubTree(root).size;
    }
    
    private static BSTInfo findLargetSubTree(Node root){
        if(root == null) 
           return new BSTInfo(0, -10000000, 10000000, true);
        
        if(root.left == null && root.right == null)
           return new BSTInfo(1, root.data, root.data, true);
        
        BSTInfo leftAns = findLargetSubTree(root.left);
        BSTInfo rightAns = findLargetSubTree(root.right);
        int maximum = Math.max(Math.max(leftAns.maxValue, rightAns.maxValue), root.data);
        int minimum = Math.min(Math.min(leftAns.minValue, rightAns.minValue), root.data);
        
        if(leftAns.isBST && rightAns.isBST && root.data>leftAns.maxValue && root.data<rightAns.minValue){
            return new BSTInfo(leftAns.size+rightAns.size+1, maximum, minimum, true);
        }else{
            return new BSTInfo(Math.max(leftAns.size, rightAns.size), maximum, minimum, false);
        }
        
    }
    
}
