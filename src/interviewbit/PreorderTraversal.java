
package interviewbit;

import java.util.ArrayList;
import java.util.Stack;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
     val = x;
     left=null;
     right=null;
    }
}

public class PreorderTraversal {

	public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(A == null) {
        	return list;
        }
        while(true) {
            
            while(A != null) {
                list.add(A.val);
            	stack.push(A);
                A = A.left;
            }
            
            if(stack.isEmpty()) {
            	break;
            }
            TreeNode temp = stack.pop();
            A = temp.right;
        }
        return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
