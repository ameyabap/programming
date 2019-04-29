package hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

class Node {
	String s;
	Node left;
	Node right;
	
	
}
public class ManasaAndStones {
	
	static int[] stones(int n, int a, int b) {
		int numForPermutation = n -1;
		int noOfPermutations = (int)Math.pow(2, numForPermutation); 
		Set<Integer> set = new HashSet<Integer>();
		int incCounter = 0;
		int decCounter = numForPermutation;
		int[] result = new int[numForPermutation+1];
		for(int i = 0;i<numForPermutation+1;i++) {
			result[i] = (a*decCounter--)+(b*incCounter++);
		}
		for (int i : result) {
			set.add(i);
		} 
		int[] output = new int[set.size()];
		Iterator<Integer> iterator = set.iterator();
		int i = 0;
		while(iterator.hasNext()) {
			output[i++] = iterator.next();
		}
		Arrays.sort(output);
		return output;
//		Node root = create(numForPermutation);
//		Set<Integer> set = new HashSet<Integer>();
//		traverseTree(root, a, b, set);
//		int[] result = new int[set.size()];
//		Iterator<Integer> iterator = set.iterator();
//		int i = 0;
//		while(iterator.hasNext()) {
//			result[i++] = iterator.next();
//		}
//		Arrays.sort(result);
//		return result;
	}
	
	private static void traverseTree(Node root, int a, int b, Set<Integer> set) {
		if(root == null) {
			return;
		}
		if(root.left == null && root.right == null) {
			int total = 0;
			for(int i = 0;i< root.s.length();i++) {
				if(root.s.charAt(i)=='0') {
					total += a;
				}else {
					total += b;
				}
			}
			set.add(total);
		}else {
			traverseTree(root.left, a, b, set);
			traverseTree(root.right, a, b, set);
		}
		
	}

	private static Node create(int n) {
		Node node = new Node();
		node.s = "";
		node.left = createTree(node, 0, n);
		node.right = createTree(node, 1, n);
		return node;
	}
	

	

	private static Node createTree(Node node, int i, int num) {
		if(num == 0) {
			return null;
		}
		Node n = new Node();
		if(i == 0) {
			n.s  = node.s.trim() + "0";
		}else {
			n.s = node.s.trim() + "1";
		}
		n.left = createTree(n, 0, num-1);
		n.right = createTree(n, 1, num-1);
		return n;
	}

	public static void main(String[] args) {
//		System.out.println(Arrays.toString(new ManasaAndStones().stones(3, 1, 2)));
//		System.out.println(Arrays.toString(new ManasaAndStones().stones(4, 10, 100)));
//
		System.out.println(Arrays.toString(new ManasaAndStones().stones(58, 69, 24)));
		System.out.println(Arrays.toString(new ManasaAndStones().stones(83, 86, 81)));
		System.out.println(Arrays.toString(new ManasaAndStones().stones(73, 25, 25)));
		System.out.println(Arrays.toString(new ManasaAndStones().stones(12, 73, 82)));
		System.out.println(Arrays.toString(new ManasaAndStones().stones(5, 3, 23)));
		
		
		
	}

}
