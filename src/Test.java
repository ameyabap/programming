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

class Edge {
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Edge)) {
			return false;
		}
		Edge other = (Edge) obj;
		if (a != other.a) {
			return false;
		}
		if (b != other.b) {
			return false;
		}
		return true;
	}

	public Edge(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	int a,b;
	
}
class Test {
	static int[][] graph;
	static Map<Edge, Integer> edgeToDistance;
	static Set<Edge> edgesVisited;
	static int[] visited;
    
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
        //String name = s.nextLine();                 // Reading input from STDIN
        //System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        

        // Write your code here
        int n = s.nextInt();
        int[] arrayA = new int[n];
        int[] arrayB = new int[n];
        for(int i = 0;i<n;i++) {
        	arrayA[i] = s.nextInt() - 1; 
        }
        for(int i = 0;i<n;i++) {
        	arrayB[i] = s.nextInt() -1; 
        }
        
        int m = s.nextInt();
        graph = new int[n][n];
        
        for(int i = 0;i<n;i++) {
        	for(int j = 0;j< m;j++){
        		graph[i][j] = 0;
        	}
        	 
        }
        int v;// = s.nextInt();
    	int w;// = s.nextInt();
    	int weight;// = s.nextInt();
        
        for(int i = 0;i<m;i++) {
        	 v = s.nextInt() - 1;
        	 w = s.nextInt() - 1;
        	 weight = s.nextInt();
        	 graph[v][w] = weight;
        	 graph[w][v] = weight;
        	 
        }
        int totalCost = 0;
        edgeToDistance = new HashMap<Edge, Integer>();
        
        for(int i = 0;i<n;i++) {
        	if(arrayA[i] == arrayB[i]){
        		continue;
        	}
        	edgesVisited = new HashSet<Edge>();
        	visited = new int[n];
        	for(int i1 = 0;i1<n;i1++) {
        		visited[i1] = 0;
            }
        	int cost = findMinCost(arrayA[i], arrayB[i]);
        	totalCost += cost; 
        }
        System.out.println(totalCost);    // Writing output to STDOUT

        
    }

	private static int findMinCost(int vertexA, int vertexB) {
		
		Edge e = new Edge(vertexA, vertexB);
		if(edgeToDistance.containsKey(e)) {
			return edgeToDistance.get(e);
		}
		int graphRowsCount = graph.length;
		int minVal = Integer.MAX_VALUE;
		int currentVal = 0;
		if(graph[vertexA][vertexB] != 0) {
			minVal = graph[vertexA][vertexB];
		}
//		int[] visited;
//        visited = new int[graphRowsCount];
        
		for(int i = 0; i< graphRowsCount; i++) {
			
			if(graph[vertexA][i]!=0 && i!= vertexB) {
				if(visited[i] == 1) {
					currentVal= Integer.MAX_VALUE;
				}else {
					visited[i] = 1;
					currentVal = graph[vertexA][i] + findMinCost(i, vertexB);
				}

			}
			if(currentVal > 0 && currentVal < minVal) {
				minVal = currentVal;
			}
		}
		edgeToDistance.put(new Edge(vertexA, vertexB), minVal);
		return minVal;
	}
}
