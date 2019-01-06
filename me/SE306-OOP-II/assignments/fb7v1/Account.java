package fb7v1;

public class Account {
	
	private String firstName;
	private String surName;
	private String mobOrEmail;
	private char[] password;
	private String birthday;
	private String gender="none";
	
	public Account(String firstName, String surName ,
			String mobOrEmail, char[] password2,String birthday,String gender) {
		// TODO Auto-generated constructor stub
		
		this.firstName = firstName;
		this.surName = surName;
		this.mobOrEmail = mobOrEmail;
		this.password = password2;
		this.birthday = birthday;
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSurName() {
		return surName;
	}

	public String getGender() {
		return gender;
	}
/*	public String toString() {
		// TODO Auto-generated method stub
		return "firstName: " + this.firstName + "\nsurName: " + this.surName + "\n mobOrEmail: " + this.mobOrEmail + "\n Birthday: " + this.gender;  
	}
	
*/

	public String getMobOrEmail() {
		return mobOrEmail;
	}

	public String getBirthday() {
		return birthday;
	}

	public char[] getPassword() {
		return password;
	}

	
}
