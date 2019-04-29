package interview.amazon;

/*
 Problem: 
		Given a 2D grid with some cells marked and unmarked, identify the patch of marked cells 
		with largest boundary. 
		A patch can be defined as group of marked cells which share its edges with another marked cell.
		Boundary of a patch is defined as part of patch which touches unmarked cells. 

		Sample grid:

		  _   _   _   _   _   _   _ 
		| 1 | 1 | 1 | 0 | 1 | 0 | 1 |
		  _   _   _   _   _   _   _ 
		| 1 | 0 | 1 | 0 | 1 | 0 | 1 |
		  _   _   _   _   _   _   _ 
		| 1 | 0 | 1 | 0 | 0 | 0 | 1 |
		  _   _   _   _   _   _   _ 
		| 1 | 1 | 1 | 0 | 1 | 1 | 1 |
		  _   _   _   _   _   _   _ 


		Grid with patches identified
		  _   _   _   _   _   _   _ 
		| X | X | X | 0 | Y | 0 | Z |
		  _   _   _   _   _   _   _ 
		| X | 0 | X | 0 | Y | 0 | Z |
		  _   _   _   _   _   _   _ 
		| X | 0 | X | 0 | 0 | 0 | Z |
		  _   _   _   _   _   _   _ 
		| X | X | X | 0 | Z | Z | Z |
		  _   _   _   _   _   _   _ 



		Three patches can be found in the grid, marked as X, Y and Z patches

		Boundary of X region is 10
		Boundary of Y region is 5
		Boundary of Z region is 6
 
 */
public class MaxBoundaryArea {
	boolean[][] visited;	
	int maxBoundary(int[][] arr, int m, int n) {
		    
		    visited = new boolean[m][n];
		    for(int i = 0;i<m;i++) {
		    	for(int j = 0;j<n;j++) {
			        visited[i][j] = false;		    		
		    	}
		    }
		    int max = 0;
		    int currentSize;
		    for(int i = 0;i<m;i++) {
		        for(int j = 0;j<n;j++) {
		            if(arr[i][j] == 1 && visited[i][j] == false) {
		                currentSize = dfs(arr, i, j, m, n);
		                if(currentSize >max) {
		                    max = currentSize;
		                }
		            }
		        }
		    }
		    
		    return max;
		    
		}

		int dfs(int[][] arr, int x, int y, int rows, int cols) {
		    visited[x][y] = true;
		    int currentBoundary = 0;
		    if(x+1 < rows){
		        if(arr[x+1][y] == 0){
		            currentBoundary++;
		        }else if(visited[x+1][y] == false) {
		            currentBoundary = currentBoundary + dfs(arr, x+1, y, rows, cols);
		        }
		    }
		    if(x-1 >= 0){
		        if(arr[x-1][y] == 0){
		            currentBoundary++;
		        }else if(visited[x-1][y] == false) {
		            currentBoundary = currentBoundary + dfs(arr, x-1, y, rows, cols);
		        }
		    }
		    
		    if(y-1 >= 0){
		        if(arr[x][y-1] == 0){
		            currentBoundary++;
		        }else if(visited[x][y-1] == false) {
		            currentBoundary = currentBoundary + dfs(arr, x, y-1, rows, cols);
		        }
		    }
		    
		    if(y+1 < cols){
		        if(arr[x][y+1] == 0){
		            currentBoundary++;
		        }else if(visited[x][y+1] == false) {
		            currentBoundary = currentBoundary + dfs(arr, x, y+1, rows, cols);
		        }
		    }
		    
		    return currentBoundary;
		    
		}

	
}
