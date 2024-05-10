class TreeNode{
    int val;
    TreeNode left =null;
    TreeNode right=null;
    
    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
    public TreeNode(int val){
        this.val = val;
    }
}

class Solution
{
    public int[] sortedArrayToBST(int[] nums)
    {
        // Code here 
        TreeNode root = arrayToBST(nums, 0 , nums.length-1);
        getThePreOrder(root, nums, new int[]{0});
        
        return nums;
    }
    
    private void getThePreOrder(TreeNode root, int[] nums, int[] index){
        if(root == null) return;
        
        nums[index[0]] = root.val;
        index[0]+=1;
        getThePreOrder(root.left, nums, index);
        getThePreOrder(root.right, nums, index);
        
        return;
    }
    
    private TreeNode arrayToBST(int[] nums, int start, int end){
        if(start>end) return null;
        
        int mid = start + (end-start)/2;
        TreeNode node = new TreeNode(nums[mid], null, null);
        
        node.left = arrayToBST(nums, start, mid-1);
        node.right = arrayToBST(nums, mid+1, end);
        
        return node;
    }
}
