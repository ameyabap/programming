package hackerrank;

import java.util.Stack;

public class BalancedBrackets {

	static String isBalanced(String s) {
		Stack<Character> stack = new Stack<Character>();
		String no = "NO";
		String yes = "YES";
		for(int i = 0;i<s.length();i++) {
			char ch = s.charAt(i);
			switch (ch) {
			case '(':
			case '[':
			case '{':
				stack.push(ch);
				break;
			case ')':
				if(stack.isEmpty()) {
					return no;
				}
				if(stack.pop() != '(') {
					return no;
				}
				break;
			case ']':
				if(stack.isEmpty()) {
					return no;
				}
				if(stack.pop() != '[') {
					return no;
				}
				break;
			case '}':
				if(stack.isEmpty()) {
					return no;
				}
				if(stack.pop() != '{') {
					return no;
				}
				break;
			default:
				break;
			}
		}
		
		return stack.isEmpty() ? yes : no;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isBalanced("{{[[(())]]}}"));
		System.out.println(isBalanced("{[(])}"));
	}

}
