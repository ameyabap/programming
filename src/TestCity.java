import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TestCity {
    static class Graph{
        int v;
        LinkedList<Integer> adj[];
        Graph(int v){
        	this.v = v;
            adj = new LinkedList[v];
            for(int i = 0;i<v;i++) {
                adj[i] = new LinkedList<Integer>();
            }
        }
        void addEdge(int s, int d){
            adj[s].add(d);
            adj[d].add(s);
        }
        LinkedList<Integer> bfs(int start){
        	boolean visited[] = new boolean[v];
        	LinkedList<Integer> q = new LinkedList<Integer>();
        	q.add(start);
        	LinkedList<Integer> result = new LinkedList<>(); 
        	visited[start]=true;
        	while(!q.isEmpty()) {
        		int temp = q.poll();
        		result.add(temp);
        		Iterator<Integer> list = adj[temp].listIterator();
        		while(list.hasNext()) {
        			int cityId = list.next();
        			if(visited[cityId] == false) {
        				q.add(cityId);
        				visited[cityId] = true;
        			}
        			
        		}
        		visited[temp] = true;
        	}
        	return result;
        }
    }
    
    // Complete the roadsAndLibraries function below.
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
    	int visited[] = new int[n];
    	Arrays.fill(visited, 0);
    	
    	Graph g = new Graph(n);
    	for(int i = 0;i<cities.length;i++) {
    		g.addEdge(cities[i][0]-1, cities[i][1]-1);
    	}
    	if(c_road >= c_lib) {
            return (long)n*c_lib;
        }
    	int cost = 0;
        while(getNotVisited(visited) != -1) {
        	int starNode = getNotVisited(visited);
        	LinkedList<Integer> list = g.bfs(starNode);
        	cost = cost + ((list.size() - 1)*c_road + c_lib);
        	Iterator<Integer> i = list.listIterator();
        	while(i.hasNext()) {
        		visited[i.next()] = 1;
        	}
        }
        
        return cost;

    }

    private static int getNotVisited(int[] visited) {
		// TODO Auto-generated method stub
    	for (int i = 0 ; i<visited.length;i++) {
			if(visited[i] == 0){
				return i;
			}
		}
		return -1;
	}

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nmC_libC_road = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmC_libC_road[0]);

            int m = Integer.parseInt(nmC_libC_road[1]);

            int c_lib = Integer.parseInt(nmC_libC_road[2]);

            int c_road = Integer.parseInt(nmC_libC_road[3]);

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] citiesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
                    cities[i][j] = citiesItem;
                }
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
