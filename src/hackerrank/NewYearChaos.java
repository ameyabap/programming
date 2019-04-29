package hackerrank;

public class NewYearChaos {

	// Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        // int count = 0;
        // int placeValue = 0;
        // int diff = 0;
        // for(int i = 0;i<q.length;i++) {
        //     placeValue = i + 1;
        //     diff = q[i] - placeValue;

        //     if(diff <=0) {
        //         continue;
        //     }else if(diff <= 2) {
        //         count += diff;
        //     }else {
        //         count = -1;
        //         break;
        //     }
        // }
        // if(count == -1) {

        //  System.out.println("Too chaotic");
        //  }else {

        //   System.out.println(count);  
        //  }
        int bribe = 0;
    boolean chaotic = false;
    int n = q.length;
    for(int i = 0; i < n; i++)
    {
        if(q[i]-(i+1) > 2)
        {               
            chaotic = true;
            break;     
        }
        for (int j = Math.max(0, q[i]-1-1); j < i; j++)
            if (q[j] > q[i]) 
                bribe++;
    }
    if(chaotic == true)
        System.out.println("Too chaotic");
    else
     {
        System.out.println(bribe);

    }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		minimumBribes(new int[]{1,2,5,3,7,8,6,4});

	}

}
