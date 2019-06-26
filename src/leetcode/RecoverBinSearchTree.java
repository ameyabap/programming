package leetcode;



   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class RecoverBinSearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void recoverTree(TreeNode root) {
        TreeNode leftMax = findLeftMax(root.left);
        TreeNode rightMax = findRightMin(root.left);
        
    }
	private TreeNode findLeftMax(TreeNode root) {
		if(root.right == null)
			return root;
		
		while(root.right !=null) {
			root = root.right;
		}
		return root;
	}
	private TreeNode findRightMin(TreeNode root) {
		if(root.left == null)
			return root;
		
		while(root.left !=null) {
			root = root.left;
		}
		return root;
	}
}
