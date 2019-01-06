package lab;

public class Customer {
	private int id;
	private char[]password;
	private String name;
	private String phone;
	private double balance;
	private String type;
	
	public Customer(int id,char[]password,String name,String phone,double balance,String type) {
		this.setId(id);
		this.setPassword(password);
		this.setName(name);
		this.setPhone(phone);
		this.setBalance(balance);
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
