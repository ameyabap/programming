package leetcode;

public class SecondsToHours {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(7500));
		System.out.println(solution(83643));

	}
	public static String solution(int seconds) {
        // write your code in Java SE 8
		int secs = seconds % 60;
        int hrs = seconds / 60;
        int mins = hrs % 60;
        hrs = hrs / 60;
        return hrs + "h" + mins + "m" + secs + "s";
    }

}
