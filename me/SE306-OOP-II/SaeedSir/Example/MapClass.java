package Example;

import java.util.TreeMap;

public class MapClass {
	
	public MapClass() {
		// TODO Auto-generated constructor stub
		
		TreeMap<String, Student> studentMap = new TreeMap<String, Student>();  
		
		Student s1 = new Student("Tahil", "BSSE0803", 20, "Savar");
		Student s2 = new Student("Tahmid", "BSSE0801", 21, "Dhaka");
		Student s3 = new Student("Khalil", "BSSE0804", 20, "Voirob");
		Student s4 = new Student("Khyrul", "BSSE0822", 22, "Bogra");
		
		studentMap.put(s1.getRoll(), s1);
		studentMap.put(s2.getRoll(), s2);
		studentMap.put(s3.getRoll(), s3);
		studentMap.put(s4.getRoll(), s4);
		
		
		for(String key : studentMap.keySet()){
			Student value = studentMap.get(key);
			
			System.out.println(key + " -> " + value);
		}
		
		
	}

}
