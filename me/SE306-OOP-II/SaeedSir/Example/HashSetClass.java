package collection.Example;

import java.util.HashSet;

public class HashSetClass {
	
	public HashSetClass() {
		// TODO Auto-generated constructor stub
		HashSet<String> set = new HashSet();
		  set.add("Ravi");  
		  set.add("Vijay");  
		  set.add("Ravi");  
		  set.add("Ajay");
		  
		  for (String string : set) {
			System.out.println(string);
		}
	}

}
