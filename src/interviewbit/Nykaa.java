package interviewbit;

public class Nykaa {

	static final int MAX = 100; 
	  
    static void printMatrixDiagonal(int mat[][], int m, int n) 
    { 
        // Initialize indexes of element to be printed next 
        int i = 0, j = 0; 
  
        // Direction is initially from down to up 
        boolean isUp = true; 
  
        // Traverse the matrix till all elements get traversed 
        for (int k = 0; k < m * n;) { 
            // If isUp = true then traverse from downward 
            // to upward 
            if (isUp) { 
                for (; i >= 0 && j < n; j++, i--) { 
                    System.out.print(mat[i][j] + " "); 
                    k++; 
                } 
  
                // Set i and j according to direction 
                if (i < 0 && j <= n - 1) 
                    i = 0; 
                if (j == n) { 
                    i = i + 2; 
                    j--; 
                } 
            } 
  
            // If isUp = 0 then traverse up to down 
            else { 
                for (; j >= 0 && i < m; i++, j--) { 
                    System.out.print(mat[i][j] + " "); 
                    k++; 
                } 
  
                // Set i and j according to direction 
                if (j < 0 && i <= m - 1) 
                    j = 0; 
                if (i == m) { 
                    j = j + 2; 
                    i--; 
                } 
            } 
  
            // Revert the isUp to change the direction 
            isUp = !isUp; 
        } 
    } 
  
    // Driver code 
    public static void main(String[] args) 
    { 
        int mat[][] = { { 1, 2, 3, 10 }, 
                        { 4, 5, 6, 11 }, 
                        { 7, 8, 9, 12 } }; 
  
        int n = 3; 
        printMatrixDiagonal(mat, 3, 4); 
    } 

}
