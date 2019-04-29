import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

 class Post {
    int row;
    int col;
    public Post(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public boolean equals(Post p) {
        return this.row == p.row && this.col == p.col;
    }
    
}
public class Test1 {

    
    // Complete the gridlandMetro function below.
    static int gridlandMetro(int n, int m, int k, int[][] track) {
    	ArrayList<Post> tracks = new ArrayList<Post>();
        
        int row= 0, c1,c2, occupied = 0;
        for(int i = 0;i<k;i++) {
            row = track[i][0] - 1;
            c1 = track[i][1] - 1;
            c2 = track[i][2] - 1;
            for(int j = c1; j<=c2;j++) {
                Post p = new Post(row, j);
                if(!tracks.contains(p)) {
                    tracks.add(p);
                }
            }
        }
        
        return n*m - tracks.size();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nmk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nmk[0]);

        int m = Integer.parseInt(nmk[1]);

        int k = Integer.parseInt(nmk[2]);

        int[][] track = new int[k][3];

        for (int i = 0; i < k; i++) {
            String[] trackRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int trackItem = Integer.parseInt(trackRowItems[j]);
                track[i][j] = trackItem;
            }
        }

        int result = gridlandMetro(n, m, k, track);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
