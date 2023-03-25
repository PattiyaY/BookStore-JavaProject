package BookStoreApp_Fullversion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Data {

	    public List<String[]> parse(String filename, String delimiter) throws FileNotFoundException {
	        List<String[]> rows = new ArrayList<>();
	        Scanner scanner = new Scanner(new File(filename));
	        scanner.useDelimiter(delimiter);

	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine().replaceAll("\"", "");;
	            String[] fields = line.split(delimiter);
	            rows.add(fields);
	        }

	        scanner.close();
	        return rows;
	    }
		
}
