import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *	Docs:
 *	https://docs.oracle.com/javase/7/docs/api/java/io/BufferedReader.html
 **/
public class BufferedReaderExample {
	public static void main(String[] args) throws Exception {

		// some variables
		String currentLine;
		int currentChar;

		try {

			// im assuming this file exists since this is my example
			File file = new File("./input.txt");

			// since buffered writter takes a writter as an arguement
			// we will supply a FileWriter
			FileReader fr = new FileReader(file.getAbsoluteFile());

			BufferedReader br = new BufferedReader(fr);

			// read ahead 1000 characters
			// so I can easily reset for a second example
			br.mark(1000);

			// read the file line by line.
			// input.txt only has one line.
			int lineCount = 0;
			while ((currentLine = br.readLine()) != null) {
				System.out.println(currentLine);
				lineCount++;
			}


			System.out.println("Line Count : " + lineCount);

			// reset the mark. start the next example
			br.reset();

			// read the file character by character
			int charCount = 0;
			while ((currentChar = br.read()) != -1) {
				System.out.print((char)currentChar);
				charCount++;
			}

			System.out.println("Character Count : " + charCount);

			br.close();

			System.out.println("Done");

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
