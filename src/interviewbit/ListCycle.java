/**
 * 
 */
package interviewbit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ameyabapat
 *
 */


  class ListNode {
     public int val;
     public ListNode next;
     ListNode(int x) { val = x; next = null; }
 }

public class ListCycle {

	public ListNode detectCycle(ListNode a) {
		Set<ListNode> list = new HashSet<ListNode>();
		
		while(a != null) {
			if(list.contains(a)) {
				return a;
			}else {
				list.add(a);
			}
			a = a.next;
		}
		return null;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
