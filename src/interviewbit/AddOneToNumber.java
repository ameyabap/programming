package interviewbit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AddOneToNumber {

	
	public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int reminder = 1; int sum = 0; int val = 0;
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        while(A.get(0) < 1) {
        	A.remove(0);
        }
        for(int i = A.size()-1;i>=0;i--) {
            
            sum = A.get(i) + reminder;
            
            if(sum > 9) {
                reminder  = 1;
                sum = sum % 10;
            }else {
            	reminder = 0;
            }
            list.addFirst(sum);
        }
        if(reminder == 1) {
        	list.addFirst(reminder);
        }
        ArrayList<Integer> result = new ArrayList<Integer>(list);
        return result;
    }
	public static void main(String[] args) {

		
	}

}
