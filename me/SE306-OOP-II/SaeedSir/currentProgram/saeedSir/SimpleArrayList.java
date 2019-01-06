package saeedSir;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Iterator;

public class SimpleArrayList {
	
	public static void main(String [] args) {
		ArrayList<String> c;
		c = new ArrayList<String>();
		System.out.println(c.getClass().getName());
		for(int i=1;i<=10;i++){
			c.add(i+"*"+i+" = "+i*i);
		}
		//c.add(10);
		c.add("ddd");
		/*for(String str : c){
			System.out.println(str);
		} */
		
		for(int i=0;i<c.size();i++){
			System.out.println(c.get(i));
		}
		
		
		/*Iterator<> iter = c.iterator();
		
		while(iter.hasNext()){
			String temp = iter.next().toString();
			System.out.println(temp);
			System.out.println(iter.next());
		}
		
		*/
	}

}
