package aa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class fileReader{
    public static ArrayList readFile(String incomingMessage) {
		String VehicleDetails;
		ArrayList<String> splittedLines = new ArrayList<String>();
		ArrayList<String>  VehicleIDsArray = new ArrayList<String>();
        ArrayList<String> VehicleArray = new ArrayList<String>();
        ArrayList<String> Info = new ArrayList<String>();
		int index=0;
		int found = 0;
		
		try {
		File VehicleFile = new File("Vehicle.txt");
		Scanner fileRead = new Scanner(VehicleFile);
		while (fileRead.hasNextLine()) {
			
			VehicleDetails = fileRead.nextLine();
            String splitted []=VehicleDetails.split(" ");
			splittedLines.add(splitted[0]);
			
		    
			VehicleIDsArray.add(splittedLines.get(index));
			
			index+=1;
			VehicleArray.add(VehicleDetails);
			
			
			
	
		}
		
		for(int i = 0; i <= 4; i++) {
			if(VehicleIDsArray.get(i).equals(incomingMessage)) {
				 
		
				Info.add(VehicleArray.get(i));
				found = 1;
				
				
				return Info;
				
				
			}
		}
		if(found == 0) {
			String sen[] = {"Vehicle is not found !!"};
			
			for(int i = 0; i <= 4; i++) {
			Info.add(sen[i]);
			return Info;
			}
		}
	
		
		
		}
		
		catch(FileNotFoundException e) {
			System.out.println("The Vehicle file cannot be found! Please make sure the file already exists.");
			
		}
		return Info;
		
	}
    
}


