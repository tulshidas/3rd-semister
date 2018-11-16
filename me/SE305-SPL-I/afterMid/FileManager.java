package afterMid;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {
	
	private static String FILENAME ;
	private static String filesOfDigit[]= {"zero.txt","one.txt","two.txt","three.txt",
			"four.txt","five.txt","six.txt","seven.txt","eight.txt","nine.txt"};
	
	public static void  writeToFile_BufferWriter(String content) {
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			//open filewriter as append mode
			fw = new FileWriter(FILENAME,true);
						
			bw = new BufferedWriter(fw);
			bw.write(content);
			bw.newLine();

			System.out.println("Write Done: " + content);
			
			if (bw != null)
				bw.close();

			if (fw != null)
				fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public static ArrayList<Integer> readFromFile(int index) {
		ArrayList<Integer>digit=new ArrayList<Integer>() ;
		
		try {

			int x,y;
			
			Scanner input = new Scanner(new File("C:/Users/User/workspace/splMid1/src/digits/"+filesOfDigit[index]));

			while ((input.hasNext())) {
				
				x = input.nextInt();
				y = input.nextInt();
				digit.add(x);
				digit.add(y);

			}
			
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
		return digit;
	}
	
}
