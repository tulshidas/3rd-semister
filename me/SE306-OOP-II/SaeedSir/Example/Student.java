package collection.Example;

import java.util.Date;

public class Student {
	
	private String name;
	private String roll;
	private int age;
	private String address;
	
	public Student(String name, String batch) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.roll = batch;
	}
	
	public Student(String name, String roll, int age) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.roll = roll;
		this.age = age;
	}
	
	public Student(String name, String roll, int age, String add) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.roll = roll;
		this.age = age;
		this.address = add;
	}


	
	public void setAddress(String add){
		this.address = add;
	}
	
	public String getName(){
		return this.name;
	}

	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		// TODO Auto-generated method stub
		return "Name: " + name + ", Roll: " + roll + ", Age: " + age + ", Address: " + address;  
	}

}
