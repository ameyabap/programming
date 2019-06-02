package leetcode;

// you can also use imports, for example:
// import java.util.*;
import java.util.HashMap;
import java.util.Map;
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class MaxSquareRoots {
    static Map<Integer, Integer> intToNoOfSqrRoots;
    // public int solution(int A, int B) {
    //     // write your code in Java SE 8
    // }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		//intToNoOfSqrRoots = new HashMap<Integer,Integer>();
		//System.out.println(squareRoots(255));
		//System.out.println(solution(10,20));
		System.out.println(solution(6000,7000));
	}
    public static int solution(int A, int B) {
        // write your code in Java SE 8
		intToNoOfSqrRoots = new HashMap<Integer,Integer>();
		int maxRoots = 0;
		int currNoOfRoots = 0;
		for(int i = A;i< B;i++){
			currNoOfRoots = squareRoots(i);
			maxRoots = Math.max(maxRoots, currNoOfRoots);
		}
		
		return maxRoots;
		
    }
	private static int squareRoots(int i) {
		
		if(intToNoOfSqrRoots.containsKey(i)) {
			return intToNoOfSqrRoots.get(i);
		}
		double sqrRoot = Math.sqrt(i);
		int noOfRoots = 0;
		if(sqrRoot == Math.floor(sqrRoot)) {
			int number = (int)Math.floor(sqrRoot);
			noOfRoots = 1 + squareRoots(number);
		}
		if(noOfRoots > 0) {
			intToNoOfSqrRoots.put(i, noOfRoots);
		}
		return noOfRoots;
	}
}