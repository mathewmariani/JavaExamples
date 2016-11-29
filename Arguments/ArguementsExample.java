/**
 *	Docs:
 *	https://docs.oracle.com/javase/7/docs/api/java/lang/Exception.html
 **/
public class ArgumentsExample {

	// These are Command Line Arguments
	public static void main(String[] args) {
		for (String arg : args) {
			System.out.println("arguement : " + arg);
		}
	}
}
