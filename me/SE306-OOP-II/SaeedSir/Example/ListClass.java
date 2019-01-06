package collection.Example;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

import collection.Example.Student;

public class ListClass {
	
	public ListClass() {
		// TODO Auto-generated constructor stub
		
		ArrayList<Student> students = new ArrayList();
		
		Student s1 = new Student("Tahil", "BSSE0803", 20, "Rangpur");
		
		students.add(s1);
		students.add(new Student("Mahir", "BSSE0806"));
		students.add(new Student("Ibrahim", "BSSE0804", 21));
		
//		printListType2(students);
		printListType3(students);
		System.out.println("is empty: " + students.isEmpty());
		
		students.add(0, new Student("Rifad", "BSSE0224", 21));		
		printListType1(students);
		
		students.set(2, new Student("Jubayer", "BSSE0217", 20));
		printListType3(students);
		
		System.out.println(students.indexOf(s1));
		
		students.remove(students.indexOf(s1));
		students.remove(s1);
		
		printListType2(students);
		
	}
	
	//print all the item inside a list
	private void printListType1(ArrayList<Student> list){
		// iteration in a list
		for (Student student : list) {
			System.out.println(student);
			//null check
//			System.out.println(student.getName());
//			if(student.getAddress()!=null)
//				System.out.println(student.toString());
		}
		System.out.println();
	}
	
	
	//print all the item inside a list
		private void printListType2(ArrayList<Student> list){
			// iteration in a list
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Student student = (Student) iterator.next();
				System.out.println(student);
			}
			System.out.println();
		}
	
		
		//print all the item inside a list
		private void printListType3(ArrayList<Student> list){
			// iteration in a list
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));	
			}
			System.out.println();
		}

}


