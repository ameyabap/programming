package interview.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class QItem { 
	int row; 
	int col; 
	int dist; 
	QItem(int x, int y, int w) 
	{ 
		this.row = x;
		this.col = y;
		this.dist = w;
	}
	
}
public class MinimumPathInMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{1, 0,0}, {1, 0, 0}, {1, 9, 1}};
		
		//int result = minDistance(grid, 3, 3);
		List<List<Integer>> a = new ArrayList<>();
		a.add(Arrays.asList(new Integer[] {1,0,0}));
		a.add(Arrays.asList(new Integer[] {1,0,0}));
		a.add(Arrays.asList(new Integer[] {1,9,1}));
		int result = removeObstacle(3, 3, a);
		System.out.println(result);
	}
	
	 static int removeObstacle(int numRows, int numColumns, List<List<Integer>> a)
	 {
		 	int C = numColumns;
			int R = numRows;
			int[][] maze = new int[R][C];
			
			for (int i = 0; i< a.size(); i++) {
				List<Integer> row = a.get(i);
				for (int j = 0; j<row.size(); j++) {
					int val = row.get(j);
					maze[i][j] = val;
				}
			}
			for(int i = 0; i<R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(maze[i][j] + " ");
				}
				System.out.println();
			}
			return minDistance(maze, R, C);
	 }
	 
	 
	 static int minDistance(int grid[][], int N, int M) 
	 { 
	 	QItem source = new QItem(0, 0, 0); 

	 	// To keep track of visited QItems. Marking 
	 	// blocked cells as visited. 
	 	boolean visited[][] = new boolean[N][M]; 
	
		source.row = 0; 
		source.col = 0; 
	
	 	for (int i = 0; i < N; i++) { 
	 		for (int j = 0; j < M; j++) 
	 		{ 
	 			if (grid[i][j] == 0) 
	 				visited[i][j] = true; 
	 			else
	 				visited[i][j] = false; 
	 			 
	 		} 
	 	} 

	 	// applying BFS on matrix cells starting from source 
	 	Queue<QItem> q = new LinkedList<QItem>(); 
	 	q.add(source); 
	 	visited[source.row][source.col] = true; 
	 	while (!q.isEmpty()) { 
	 		QItem p = q.remove(); 

	 		// Destination found; 
	 		if (grid[p.row][p.col] == 9) 
	 			return p.dist; 

	 		// moving up 
	 		if (p.row - 1 >= 0 && 
	 			visited[p.row - 1][p.col] == false) { 
	 			q.add(new QItem(p.row - 1, p.col, p.dist + 1)); 
	 			visited[p.row - 1][p.col] = true; 
	 		} 

	 		// moving down 
	 		if (p.row + 1 < N && 
	 			visited[p.row + 1][p.col] == false) { 
	 			q.add(new QItem(p.row + 1, p.col, p.dist + 1)); 
	 			visited[p.row + 1][p.col] = true; 
	 		} 

	 		// moving left 
	 		if (p.col - 1 >= 0 && 
	 			visited[p.row][p.col - 1] == false) { 
	 			q.add(new QItem(p.row, p.col - 1, p.dist + 1)); 
	 			visited[p.row][p.col - 1] = true; 
	 		} 

	 		// moving right 
	 		if (p.col + 1 < M && 
	 			visited[p.row][p.col + 1] == false) { 
	 			q.add(new QItem(p.row, p.col + 1, p.dist + 1)); 
	 			visited[p.row][p.col + 1] = true; 
	 		} 
	 	} 
	 	return -1; 
	 } 


}
