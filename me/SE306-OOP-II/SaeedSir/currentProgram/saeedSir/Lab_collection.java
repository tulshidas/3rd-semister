package saeedSir;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

public class Lab_collection {
	public Lab_collection() {
		// TODO Auto-generated constructor stub
		//TreeSet<String> hset = new TreeSet<>();
		//HashSet<String> hset = new HashSet<String>();
		
		HashMap<String,String> hMap = new HashMap<String,String>();
		
	/*	 hset.add("Tushar");
		hset.add("Tahlil");
		hset.add("Jubayer");
		
	*/
		hMap.put("BSSE0801", "Tahmid");
		hMap.put("BSSE0811", "Tulshi");
		hMap.put("BSSE082", "Jamil");
		
		for(Entry<String, String> m: hMap.entrySet()){
			System.out.println(m.getKey());
			
		}
		
	
	}
		
		
	/*	Iterator<String> itr = hset.iterator();
		
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
	
	*/
	
	public static void main(String []args) {
		new Lab_collection();
	}
	
}
