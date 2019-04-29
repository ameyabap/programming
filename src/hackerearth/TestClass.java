package hackerearth;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
 */
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input
         
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
        */
        //Scanner
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int j = 0; j<t; j++) {
        	
        
        int n = s.nextInt();
        int[] array = new int[n];
        int[][] visited = new int[n][n];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0;i<n;i++) {
        	for(int p = 0;p<n;p++) {
        		visited[i][p]=0;
        	}
        }
        for(int i = 0;i<n;i++) {
            array[i] = s.nextInt();
            	map.put(array[i],i);
        }
        int k = s.nextInt();
        boolean isFound = false;
        int temp = -1; int value = -1;
        int count = 0;
        for(int i = 0;i<n;i++) {
        	temp = k - array[i];
        	value = map.getOrDefault(temp, -1);
            if(value > 0 && value != i && !isAlreadySeen(i, value, visited))
            {
            	count++;
            	visited[i][value] = 1;
            	visited[value][i] = 1;
            }
        }
        System.out.println(count);
        }
        

        // Write your code here

    }

	private static boolean isAlreadySeen(int index1, int index2, int[][] visited) {
		
		return visited[index1][index2] == 1 || visited[index1][index2] == 1;
	}
}
