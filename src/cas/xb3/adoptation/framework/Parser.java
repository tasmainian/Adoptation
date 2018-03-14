package cas.xb3.adoptation.framework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {
	
	public static ArrayList<petADT> parse(String s) throws IOException {
		String csvFile = s;
		String line;
		ArrayList<petADT> pets = new ArrayList<petADT>();
		BufferedReader br = new BufferedReader(new FileReader(csvFile));
		line = br.readLine();
		while ((line = br.readLine()) != null) {
			line = line.replace("\"", "");
			String[] cols = line.split(",");
			petADT pet = new petADT(cols[0],cols[2], cols[3],cols[4], cols[10], cols[11], cols[7], cols[8],cols[1], cols[14]);
			pets.add(pet);	
		}  
		
		
		//for testing
//		for (petADT petObject : pets) {
//			System.out.println(petObject.getSpecies());
//		}
						
		return pets;
	}
	
	//for testing
//	public static void main(String[] args) throws IOException {
//		parse("C:\\Users\\Abdul Elrahwa\\Downloads\\Animal_Tag_DATA_2015_8.csv");
//	}

}
