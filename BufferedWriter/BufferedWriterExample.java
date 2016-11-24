import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterExample {
	
	/**
	 *	Mathew Mariani
	 *
	 *	Docs:
	 *	https://docs.oracle.com/javase/7/docs/api/java/io/BufferedWriter.html
	 **/
	public static void main(String[] args) {

		//
		// we will write some basic data to a file
		//

		try {
			// This is the file we will be using
			File file = new File("./output.txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// since buffered writter takes a writter as an arguement
			// we will supply a FileWriter
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			// write to file
			bw.write("This is be written to the document.");

			// create a new line
			bw.newLine();

			// these will all be written on the same line
			bw.write("First");
			bw.write(" : ");
			bw.write("Second");

			// closing will always flush the stream first
			bw.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}