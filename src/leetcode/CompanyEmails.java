package leetcode;

import java.util.HashMap;
import java.util.Map;

public class CompanyEmails {

	public static void main(String[] args) {
		System.out.println(solution("John Doe; Peter Arya Parker; Mary Jane Watson-Parkar; John Elvis Doe; John Evan Doe; Peter Bay Parker", "Example"));
		
	}
	/**
	 * 
	 * @param S
	 * @param C
	 * @return
	 */
	public static String solution(String S, String C) {
		String[] fullNames = S.split("; ");
		Map<String, Integer> emails = new HashMap<String, Integer>();
		String result = "";
		for(int i=0;i<fullNames.length;i++) {
			String[] name = fullNames[i].split(" ");
			String firstName = name[0];
			String lastName;
			if(name.length == 3) {
				lastName = name[2];
			}else {
				lastName = name[1];
			}
			String[] lastNameParts = lastName.split("-");
			
			if(lastNameParts.length > 1) {
				lastName = "";
				for(int j = 0;j<lastNameParts.length;j++) {
					lastName = lastName + lastNameParts[j];
				}
			}
			String emailForm = lastName +  "_" + firstName;
			String email;
			int count = 0;
			if(emails.containsKey(emailForm)) {
				count = emails.get(emailForm) + 1;
				emails.put(emailForm, count);
			}else {
				emails.put(emailForm, 1);
			}
			email = createEmail(lastName, firstName, C, count);
			if(i < fullNames.length - 1) {
				result = result + email + "; ";
			}else {
				result = result + email;
			}
		}
		return result;
		
	}
	public static String createEmail(String lastName, String firstName, String C, int val) {
		String count = "";
		if(val > 0) {
			count = String.valueOf(val);
		}
		String email = lastName + "_" + firstName + count + "@" + C + ".com";
		return email.toLowerCase();
	}

}
