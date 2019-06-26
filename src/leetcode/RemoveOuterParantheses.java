package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveOuterParantheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new RemoveOuterParantheses().removeOuterParentheses("(()())(())(()(()))"));
		System.out.println(new RemoveOuterParantheses().removeOuterParentheses("()()"));

	}
	public String removeOuterParentheses(String S) {
		String subStr = S.substring(1, S.length()-1);
		return areValidParentheses(subStr) ? subStr : "";
    }
	private boolean areValidParentheses(String subStr) {
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0;i<subStr.length();i++) {
			char ch = subStr.charAt(i);
			if(ch == '(') {
				stack.push(ch);
			}else if(ch == ')'){
				if(stack.isEmpty()){
					return false;
				}
				stack.pop();
			}
		}
		
		return stack.isEmpty();
	}
	
	public static int[] twoNumberSum(int[] array, int targetSum) {
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0;i< array.length;i++) {
			set.add(array[i]);
		}
		int[] result = null; 
		for(int i = 0;i<array.length;i++) {
				int val = targetSum - array[i];
				if(targetSum / 2  == array[i]) {
					continue;
				}
				if(set.contains(val)) {
					result = new int[2];
					if(array[i] > val) {
						result[0] = array[i];
						result[1] = val;
					}else {
						result[1] = array[i];
						result[0] = val;
					}
					break;
				}
		}
		int[] empty = {};
		return result != null ? result : empty;
			
		}
	}

