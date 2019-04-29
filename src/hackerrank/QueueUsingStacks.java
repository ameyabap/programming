package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class QueueUsingStacks {
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
            stackNewestOnTop.push(value);
        }
        private void setOldStack() {
        	if(stackOldestOnTop.isEmpty()) {
        		while(!stackNewestOnTop.isEmpty()) {
        			stackOldestOnTop.push(stackNewestOnTop.pop());
        		}
        	}
        }
        public T peek() {
        	setOldStack();
        	return stackOldestOnTop.peek();
        }

        public T dequeue() {
            setOldStack();
            return stackOldestOnTop.pop();
        }
    }

    /**
     * 
Input:
10
1 42
2
1 14
3
1 28
3
1 60
1 78
2
2
     * @param args
     */
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

