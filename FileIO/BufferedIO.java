import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedIO {

	/**
	 *	Mathew Mariani
	 *
	 *	Docs:
	 *	https://docs.oracle.com/javase/7/docs/api/java/io/BufferedReader.html
	 *	https://docs.oracle.com/javase/7/docs/api/java/io/BufferedWriter.html
	 **/
	public static void main(String[] args) throws Exception {

		//
		// were going to open a document containing all 97 ascii characters, and reverse them.
		//

		StringBuilder response = new StringBuilder();
		
		try {

			// im assuming this file exists since this is my example
			File file = new File("./input.txt");

			//
			//	Reading the file
			//

			// set up our readers
			FileReader fr = new FileReader(file.getAbsoluteFile());		
			BufferedReader br = new BufferedReader(fr);
			
			int currentChar;
			while ((currentChar = br.read()) != -1) {
				response.append((char)currentChar);
			}

			System.out.println("Done Reading");
			br.close();

			//
			//	Writting the file
			//

			// set up our writers
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			String data = response.toString();
			for(int i = data.length() - 1; i > 0; i--) {
				bw.write(data.charAt(i));
			}

			System.out.println("Done Writting");
			bw.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}