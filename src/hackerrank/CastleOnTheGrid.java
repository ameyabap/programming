package hackerrank;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CastleOnTheGrid {

	static class Point {
		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
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
			if (!(obj instanceof Point)) {
				return false;
			}
			Point other = (Point) obj;
			if (x != other.x) {
				return false;
			}
			if (y != other.y) {
				return false;
			}
			return true;
		}
		int x,y;
		Point parent;
		Point(int x, int y, Point parent) {
			this.x = x;
			this.y = y;
			this.parent = parent;
		}
		
		
	}
	// Complete the minimumMoves function below.
    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
        CastleOnTheGrid classObj = new CastleOnTheGrid();
    	int rows = grid.length;
        int cols = 0;
        if(rows > 0) {
        	cols = grid[0].length();
        }
		boolean[][] visited = new boolean[rows][cols];
		HashMap<Point, Integer> distanceFromSource = new HashMap<Point, Integer>();
		Queue<Point> q = new LinkedList<Point>();
		Point start = new Point(startX, startY, new Point(startX, startY, null)); 
		q.add(start);
		distanceFromSource.put(start, 0);
		Point result = null;
		while(!q.isEmpty()) {
			Point p = q.remove();
			if(p.x == goalX && p.y == goalY) {
				result = p;
				break;
			}
			int x = p.x;
			int y = p.y;
			visited[x][y] = true;
			Point temp;
			char blocker = 'X';
			int val =  distanceFromSource.get(p); 
			if(x+1 < rows && grid[x+1].charAt(y) != blocker && !visited[x+1][y]) {
				temp = new Point(x+1, y, p);
				if(p.x == p.parent.x) {
					distanceFromSource.put(temp, val + 1);
				}else {
					distanceFromSource.put(temp, val);
				}
				
				q.add(temp);
			}
			if(x-1 >= 0 && grid[x-1].charAt(y) != blocker && !visited[x-1][y]) {
				temp = new Point(x-1, y, p);
				if(p.x == p.parent.x) {
					distanceFromSource.put(temp, val + 1);
				}else {
					distanceFromSource.put(temp, val);
				}
				q.add(temp);
			}
			if(y+1 < cols && grid[x].charAt(y+1) != blocker && !visited[x][y+1]) {
				temp = new Point(x, y+1, p);
				if(p.y == p.parent.y) {
					distanceFromSource.put(temp, val + 1);
				}else {
					distanceFromSource.put(temp, val);
				}
				q.add(temp);
			}
			if(y-1 >= 0 && grid[x].charAt(y-1) != blocker && !visited[x][y-1]) {
				temp = new Point(x, y-1, p);
				if(p.y == p.parent.y) {
					distanceFromSource.put(temp, val + 1);
				}else {
					distanceFromSource.put(temp, val);
				}
				q.add(temp);
			}
		}
		return distanceFromSource.get(result);
    }
    
	public static void main(String[] args) {
		/**
		 
		 	10
			.X..XX...X
			X.........
			.X.......X
			..........
			........X.
			.X...XXX..
			.....X..XX
			.....X.X..
			..........
			.....X..XX
			9 1 9 6
		 */
		// TODO Auto-generated method stub
		String[] grid = new String[10];
		grid[0]= ".X..XX...X";
		grid[1]= "X.........";
		grid[2]= ".X.......X";
		grid[3]= "..........";
		grid[4]= "........X.";
		grid[5]= ".X...XXX..";
		grid[6]= ".....X..XX";
		grid[7]= ".....X.X..";
		grid[8]= "..........";
		grid[9]= ".....X..XX";

		System.out.println(minimumMoves(grid, 9, 1, 9, 6));

	}

}
